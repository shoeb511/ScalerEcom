package com.scalerecom.scalerecom.Services.aiService;


import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeminiAiSupportService implements AiSupportService{
    RestTemplate restTemplate;
    public GeminiAiSupportService() {
        restTemplate = new RestTemplate();
    }

    //String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent";
    String apikey = "AIzaSyD6TRN9yOK3igVjCgWqkVJh_dt6s4Wldxw";

    @Override
    public ResponseEntity<String> geminiSupport(String content) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent" + "?key=" + apikey;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        String reuestJsom = "{" + "\"contents\": [{" + "\"parts\":[{\"text\": \"Write a story about a magic backpack.\"}]" + "}]" + "}";
        HttpEntity<String> request = new HttpEntity<>(reuestJsom, headers);
        String response = restTemplate.exchange(url, HttpMethod.POST, request, String.class).getBody();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
