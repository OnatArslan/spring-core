package com.onatarslan.springcore.project;


import com.onatarslan.springcore.workspace.Project;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
@EnableConfigurationProperties(ProjectProperties.class)
public class ProjectConfiguration {


    @Bean
    Clock clock() {
        System.out.println();
        return Clock.systemUTC();
    }

}
