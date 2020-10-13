package com.cognizant.leap.data.collector.gitlab.beans.common;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "gitlab")
@Slf4j
@Data
public class GitlabProperties {
    private String url;
    private String token;
}
