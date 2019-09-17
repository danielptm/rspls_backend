package com.rpsls.rsplsservice.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.rpsls.rsplsservice.utils.Random;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ComputerService {

    public String getComputerChoice() {
        Content content = null;
        try {
             content = Request.Get("https://codechallenge.boohma.com/random")
                    .execute().returnContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getChoice(content.toString());
    }
    private String getChoice(String result) {
        JsonElement jsonElement = new JsonParser().parse(result);
        return convertChoice(jsonElement.getAsJsonObject().get("random_number").getAsString());
    }

    private String convertChoice(String choice) {
        return Random.reduceComputerResult(choice);
    }
}
