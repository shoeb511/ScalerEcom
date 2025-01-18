package com.scalerecom.scalerecom.Controllers.aiControllers;

import com.scalerecom.scalerecom.Services.aiService.GeminiAiSupportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeminiController {
    GeminiAiSupportService geminiAiSupportService;
    public GeminiController() {
        this.geminiAiSupportService = new GeminiAiSupportService();
    }

    @PostMapping("geminisupport")
    public ResponseEntity<String> geminiChat(@RequestBody String querry) {
        return geminiAiSupportService.geminiSupport(querry);
    }
}
