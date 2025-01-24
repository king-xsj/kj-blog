package com.zhiyiyo.service.impl;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.zhiyiyo.constants.SystemConstants;
import com.zhiyiyo.domain.ResponseResult;
import com.zhiyiyo.domain.dto.LoginUserDTO;
import com.zhiyiyo.domain.entity.LoginUser;
import com.zhiyiyo.domain.vo.BlogUserLoginVo;
import com.zhiyiyo.domain.vo.UserInfoVo;
import com.zhiyiyo.enums.AppHttpCodeEnum;
import com.zhiyiyo.service.BlogLoginService;
import com.zhiyiyo.utils.Assert;
import com.zhiyiyo.utils.BeanCopyUtils;
import com.zhiyiyo.utils.JwtUtil;
import com.zhiyiyo.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

//Impl 是接口的实现类，它实现了接口定义的所有方法。通常会看到一个接口类和一个对应的实现类（例如 UserService 和 UserServiceImpl）。Impl 类负责具体的业务逻辑实现。
@Service
public class BlogLoginServiceImpl implements BlogLoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Override
    public ResponseResult login(LoginUserDTO user) {
        // 验证用户名和密码
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        Assert.notNull(authentication, AppHttpCodeEnum.LOGIN_ERROR);

        // 将用户信息存入 redis
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String token = JwtUtil.createJWT(userId);
        redisCache.setCacheObject(SystemConstants.REDIS_USER_ID_PREFIX + userId, loginUser);

        // 将 token 和用户信息返回给用户
        UserInfoVo userInfo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        userInfo.setIsAdmin(SystemConstants.ADMIN_USER.equals(loginUser.getUser().getType()));
        BlogUserLoginVo blogUserLoginVo = new BlogUserLoginVo(token, userInfo);
        logger.info("userInfo=====>1", JSON.toJSONString(blogUserLoginVo));
        return ResponseResult.okResult(blogUserLoginVo);
    }

    @Override
    public ResponseResult logout() {
        // 获取 userId
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userId = loginUser.getUser().getId().toString();

        // 从 redis 中删除用户信息
        redisCache.deleteObject(SystemConstants.REDIS_USER_ID_PREFIX + userId);
        return ResponseResult.okResult();
    }
}
