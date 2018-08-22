package com.bravin.shi.news;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bravin.shi.news.mapper")
public class NewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsApplication.class, args);
    }
}
