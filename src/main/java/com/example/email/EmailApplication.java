package com.example.email;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.email")
public class EmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class, args);
    }
/**
 *    mvn flyway:migrate
 *    mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
 *
 * **/
}
