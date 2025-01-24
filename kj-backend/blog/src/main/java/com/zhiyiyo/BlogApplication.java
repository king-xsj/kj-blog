package com.zhiyiyo;

import com.zhiyiyo.service.impl.DemoApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@MapperScan("com.zhiyiyo.mapper")
@EnableScheduling
public class BlogApplication {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    public static void main(String[] args) {
        logger.info("Constants：存储常量。\n" +
                "        Domain：表示系统中的核心业务实体或领域模型。\n" +
                "        DTO：数据传输对象，用于不同层之间的数据传递。\n" +
                "        Entity：与数据库表对应的实体类。\n" +
                "        VO：值对象，通常用于不可变的数据结构。\n" +
                "        Exception：定义和处理自定义异常。\n" +
                "        Mapper：数据访问层接口，用于数据库操作。\n" +
                "        Impl：接口的实现类，负责具体的业务逻辑实现。");

        System.out.println("helow word");
        SpringApplication.run(BlogApplication.class, args);
    }
}
