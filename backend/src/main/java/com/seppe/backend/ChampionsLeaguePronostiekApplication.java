package com.seppe.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan("com.seppe.backend.domain")
public class ChampionsLeaguePronostiekApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChampionsLeaguePronostiekApplication.class, args);
    }

}
