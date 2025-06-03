package com.example.docqa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
@EnableCaching
public class DocQaApplication {
    public static void main(String[] args) {
        SpringApplication.run(DocQaApplication.class, args);
    }
}