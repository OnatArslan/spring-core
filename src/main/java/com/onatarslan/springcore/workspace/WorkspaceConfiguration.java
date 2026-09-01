package com.onatarslan.springcore.workspace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class WorkspaceConfiguration {

    @Bean
    Clock clock() {
        return Clock.systemUTC();
    }
}
