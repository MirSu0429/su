package com.su;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * @Author: supengfei
 * @Date: 2019/1/26 17:21
 * @Description:
 */

@SpringBootApplication
@MapperScan(basePackages = "com.su.dao")
public class SuAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SuAdminApplication.class, args);
    }

}
