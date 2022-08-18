package com.lowcode.lowcodeboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.lowcode.lowcodeboot.mapper")

public class LowCodeBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LowCodeBootApplication.class, args);
    }

}
