//package com.scalerecom.scalerecom.Services.openAiService;
//
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//public class OpenAiRestTemplateConfig {
//
//    @Value(("${openai.api.key}"))
//    private String openapikey;
//
//    @Bean
//    @Qualifier("openAiRestTemplate")
//    public RestTemplate openAiRestTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getInterceptors().add((request, body, execution) ->
//        {request.getHeaders().add("Authorization", "Bearer " + openapikey);
//        return execution.execute(request, body);
//        });
//        return restTemplate;
//    }
//}
