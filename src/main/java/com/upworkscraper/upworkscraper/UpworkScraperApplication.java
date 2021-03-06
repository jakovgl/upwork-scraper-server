package com.upworkscraper.upworkscraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class UpworkScraperApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpworkScraperApplication.class, args);
	}

}
