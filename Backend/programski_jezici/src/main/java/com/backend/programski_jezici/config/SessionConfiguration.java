package com.backend.programski_jezici.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSessionRepository;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class SessionConfiguration {

    @Bean
    public MapSessionRepository sessionRepository() {
        return new MapSessionRepository(new ConcurrentHashMap<>());
    }
}

