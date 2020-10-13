package com.cognizant.leap.data.collector.gitlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties
@EnableScheduling
@EnableMongoAuditing
public class LeapDataCollectorGitlabApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeapDataCollectorGitlabApplication.class, args);
	}

}
