//package com.scalerecom.scalerecom.Services.openAiService;
//
//import com.scalerecom.scalerecom.Models.openAI.ChatRequest;
//import com.scalerecom.scalerecom.Models.openAI.ChatResponse;
//import com.scalerecom.scalerecom.Models.openAI.Message;
//import com.scalerecom.scalerecom.Models.openAI.OpneAimodel;
//import com.scalerecom.scalerecom.exception.OpenaiPlanExpireException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.net.http.HttpHeaders;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class OpenAIService {
//
//    @Qualifier("openAiRestTemplate")
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Value("${openai.model}")
//    private String model;
//
//    @Value(("${openai.api.url}"))
//    private String url;
//
//    public ChatResponse chatService(String prompt) throws OpenaiPlanExpireException {
//        List<Message> messages = new ArrayList<>();
//        Message message = new Message();
//        message.setPrompt(prompt);
//        messages.add(message);
//        ChatRequest chatRequest = new ChatRequest(model, messages, 1.1);
//
//        //System.out.println(chatRequest);
//        ChatResponse chatResponse = restTemplate.postForObject(url, chatRequest, ChatResponse.class);
//        //System.out.println(chatResponse.getReturnMessages());
//        return chatResponse;
//    }
//}
//
//
