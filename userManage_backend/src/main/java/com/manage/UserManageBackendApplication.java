package com.manage;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication()
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@MapperScan(value = "com.manage.mapper")
public class UserManageBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManageBackendApplication.class, args);
    }

}
