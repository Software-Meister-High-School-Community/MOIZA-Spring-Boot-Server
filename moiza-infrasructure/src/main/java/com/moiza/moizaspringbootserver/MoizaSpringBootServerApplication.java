package com.moiza.moizaspringbootserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MoizaSpringBootServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoizaSpringBootServerApplication.class, args);
    }

}
