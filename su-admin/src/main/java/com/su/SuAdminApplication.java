package com.su;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.su.dao")
public class SuAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuAdminApplication.class, args);
    }

}

