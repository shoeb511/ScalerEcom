package com.scalerecom.scalerecom.Services.aiService;

import org.springframework.http.ResponseEntity;

public interface AiSupportService {
    public ResponseEntity<String> geminiSupport(String content);

}
