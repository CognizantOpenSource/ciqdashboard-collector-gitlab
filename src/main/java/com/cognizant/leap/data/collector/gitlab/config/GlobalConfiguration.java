package com.cognizant.leap.data.collector.gitlab.config;

import com.cognizant.leap.data.collector.gitlab.clients.GitLabClient;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.concurrent.TimeUnit;

/**
 * Created by 784420 on 10/11/2019 5:23 PM
 */
@Configuration
public class GlobalConfiguration {

    @Autowired
    Environment environment;

    @Value("${gitlab.url}")
    private String gitLabUrl;

    @Bean
    public GitLabClient getGitLabFeignClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .client(new OkHttpClient())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .options(new Request.Options(20000, TimeUnit.MILLISECONDS, 20000, TimeUnit.MILLISECONDS, true))
                .logger(new Slf4jLogger(GitLabClient.class))
                .logLevel(Logger.Level.FULL)
                .target(GitLabClient.class, gitLabUrl);
    }
}
