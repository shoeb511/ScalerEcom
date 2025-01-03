package com.scalerecom.scalerecom.Controllers.aiControllers;

import com.scalerecom.scalerecom.Dto.ErrorDto;
import com.scalerecom.scalerecom.Models.openAI.ChatResponse;
import com.scalerecom.scalerecom.Services.openAiService.OpenAIService;
import com.scalerecom.scalerecom.exception.OpenaiPlanExpireException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OpenAIController {

    OpenAIService openAIService;
    public OpenAIController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @GetMapping("chat")
    public ResponseEntity<ChatResponse> chat(@RequestParam String prompt) {
        System.out.println("api started" + prompt);
        ChatResponse chatResponse = new ChatResponse();
        chatResponse = openAIService.chatService(prompt);
        System.out.println("api call ended");
        return new ResponseEntity<>(chatResponse, HttpStatus.OK);
    }

    @ExceptionHandler(OpenaiPlanExpireException.class)
    public ErrorDto openaiplanExpireExceptionHandler(Exception e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        return errorDto;
    }
}
