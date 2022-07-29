package com.yidatec.monomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MonomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonomerApplication.class, args);
    }

}
