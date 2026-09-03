package com.onatarslan.springcore.workspace;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class RetryConfiguration {

    @Bean("tenMinutes")
    RetryPolicy retryPolicy() {
        return new RetryPolicy(10, Duration.ofMinutes(10));
    }


    @Bean("sevenMinutes")
    RetryPolicy retryPolicyOther() {
        return new RetryPolicy(10, Duration.ofMinutes(7));
    }


    @Bean
    String forTest(@Qualifier("tenMinutes") RetryPolicy retryPolicy) {
        System.out.println(retryPolicy.toString() + "forTest bean created");
        return "Hello world";
    }

}
