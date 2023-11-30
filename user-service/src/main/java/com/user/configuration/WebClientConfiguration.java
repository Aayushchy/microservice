package com.user.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Value("${api.gateway.url}")
    private String apiGateWayUrl;

    @Bean(name = "accountClientWeb")
    public WebClient accountWebClient() {
        return WebClient.builder()
                .baseUrl(apiGateWayUrl)
                .build();
    }
}
