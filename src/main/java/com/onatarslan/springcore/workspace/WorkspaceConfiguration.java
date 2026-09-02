package com.onatarslan.springcore.workspace;

import com.onatarslan.springcore.idgen.TaskIdGenerator;
import com.onatarslan.springcore.idgen.UuidIdGenerator;
import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.config.Task;

import java.time.Clock;

@Configuration
public class WorkspaceConfiguration {

    @Bean("clock") // burada Beana isim verip inject edilen yerde Qualifier kullanabiliriz
    Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    @ConditionalOnProperty(name = "id.type", havingValue = "uuid") // matchIfMissing default false eger true ise propertie yoksa Bean yaratir
    TaskIdGenerator uuidTaskIdGenerator() {
        System.out.println("uuid generator created-------------------------------");
        return new UuidIdGenerator();
    }


    @Bean("otherClock")
    @Profile("dev") // dev ortaminda bu yaratilir burada "!dev" "dev | test"
    Clock otherClock() {
        return Clock.systemUTC();
    }

    @Bean
    @ConditionalOnProperty(name = "own.legit", havingValue = "true")
    OwnClassBeanExample ownClassBeanExample(WorkspaceRegistry registry, WorkspaceService service) {
        System.out.println("own class example working");
        return new OwnClassBeanExample(registry, service, "example-prefix");
    }



}
