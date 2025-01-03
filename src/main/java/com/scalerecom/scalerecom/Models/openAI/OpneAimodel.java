package com.scalerecom.scalerecom.Models.openAI;

public class OpneAimodel {

    private String url = "https://api.openai.com/v1/chat/completions";
    private String model = "gpt-3.5-turbo";
    //private Message message = new Message();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


}



//package com.scalerecom.scalerecom.Models;
//
//public class OpenAIModel {
//
//    private String promp;
//    private String apiUrl  = "https://api.openai.com/v1/chat/completions";
//    private String apiKey = "sk-proj-5aQm8wcdm8KH6lVlcv56WTp7NEh8xN5Xsv2dvJXgyxsWbF6EmlYOw4DI8wkitDdCD8l-py4pT3BlbkFJKvYdWs-Q_1HlBndI57nGUO18mttGkuQt-LoidH2R1o0Dam3uNW9vuOpkvtqQhO1blxGZd89aAA";
//
//    public String getPromp() {
//        return promp;
//    }
//
//    public void setPromp(String promp) {
//        this.promp = promp;
//    }
//}
