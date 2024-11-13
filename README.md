# ✨ Kim Blog ✨
一个基于 SpringBoot 和 Vue3 的博客系统

## 博客界面

## 快速开始
1. 运行 `resource/sql/kim_blog.sql`，创建数据库
2. 修改 `Kim-backend/blog/src/main/resources/application.yml` 中的配置，主要有以下两项：
   1. `spring.datasource` 中的 `url`、`username` 和 `password` 改成你自己的
   2. `spring.redis` 的 `password` 改成你自己的，没有设置 redis 密码的话可以去掉该项配置

3. 在 IDEA 中导入 Kim-backend 项目，启动 `BlogApplication`
4. 进入 Kim-frontend 目录，打开终端，运行以下命令：
   ```shell
   npm install
   npm run serve
   ```
5. 在浏览器中打开网页 [http://localhost:8080/](http://localhost:8080/)，开启博客之旅~

## FAQs
* **管理员的用户名和密码是啥呀？**

    用户名：admin，密码：123456，数据库中的其他普通账户的密码也是 123456。

* **有木有接口文档呀？**

   有的，[点我](https://www.apifox.cn/apidoc/shared-8fb9dd6e-4a7f-480f-b5f3-b7d3eda1bcc6) 查看 紧 张 刺 激 的在线接口文档。

## License