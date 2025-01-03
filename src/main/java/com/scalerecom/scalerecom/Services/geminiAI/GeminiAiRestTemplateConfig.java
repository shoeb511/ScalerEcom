package com.scalerecom.scalerecom.Services.geminiAI;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class GeminiAiRestTemplateConfig {

    @Value("${google.generativeai.api.key}")
    private String apiKey;

    @Qualifier
    @Bean
    public RestTemplate geminiRestTemplate() {

    }
}
