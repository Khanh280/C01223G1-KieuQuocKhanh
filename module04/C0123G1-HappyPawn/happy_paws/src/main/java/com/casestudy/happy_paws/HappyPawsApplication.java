package com.casestudy.happy_paws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class HappyPawsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HappyPawsApplication.class, args);
    }
}
