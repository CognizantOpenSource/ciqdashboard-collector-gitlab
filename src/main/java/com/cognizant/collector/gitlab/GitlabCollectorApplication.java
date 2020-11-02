package com.cognizant.collector.gitlab;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
@EnableAutoConfiguration
@EnableEncryptableProperties
public class GitlabCollectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitlabCollectorApplication.class, args);
	}

}
