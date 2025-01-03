package com.scalerecom.scalerecom.Models.openAI;

public class Message {
    String role = "user";
    String prompt;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
