package com.onatarslan.springcore.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.ZoneId;

@Configuration(proxyBeanMethods = false) // burada proxy kapatmak mantikli
public class TimeConfiguration {

    @Bean
    @Qualifier("clock")
    public Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    public String example(@Qualifier("clock") Clock clock) {
        return "Hello world" + clock.instant().toString();

    }

    @Bean
    public ZoneId zoneId() {
        return ZoneId.systemDefault();
    }

    @Bean
    @Qualifier("zonedClock")
    public Clock zonedClock(ZoneId zoneId) { // burada onceki Beani parametre olarak aliyoruz eger bu hep boyle olursa
                                            // proxy kapatilabilir
        return Clock.system(zoneId);
    }

}
