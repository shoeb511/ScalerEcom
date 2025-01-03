package com.scalerecom.scalerecom.Models.openAI;

import java.util.List;

public class ChatResponse {
    private List<Message> returnMessages;

    public List<Message> getReturnMessages() {
        return returnMessages;
    }

    public void setReturnMessages(List<Message> returnMessages) {
        this.returnMessages = returnMessages;
    }
}
