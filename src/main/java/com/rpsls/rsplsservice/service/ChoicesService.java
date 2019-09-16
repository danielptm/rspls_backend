package com.rpsls.rsplsservice.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.rpsls.rsplsservice.utils.Random;
import com.rpsls.rsplsservice.utils.ResourceGetter;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ChoicesService {

    private static final Logger LOGGER = Logger.getLogger(ResourceGetter.class.getName());

    /**
     * Get all choices as JsonElement from Gson library.
     * @return
     */
    public JsonElement getAllChoices() {
        return new JsonParser().parse(ResourceGetter.getFile("choices/choices.json"));
    }

    public String getRandomChoice() {
        JsonElement jsonElement = getAllChoices();
        int randomNumber = Random.numberBetweenZeroAnd(5);
        return String.valueOf(jsonElement.getAsJsonArray().get(randomNumber));
    }
}
