package com.onatarslan.springcore.core.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "orbit")
public record OrbitProperties() {

}
