package com.rpsls.rsplsservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rpsls.rsplsservice.model.Choice;
import com.rpsls.rsplsservice.model.Player;
import com.rpsls.rsplsservice.model.Result;
import com.rpsls.rsplsservice.utils.ResourceGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PlayService {

    private static final Logger LOGGER = Logger.getLogger(ResourceGetter.class.getName());

    private ResultsService resultsService;

    @Autowired
    public PlayService(ResultsService resultsService) {
        this.resultsService = resultsService;
    }
    //TODO: Implement this algorithm
    public Result playRound(Player player, Player computer) {
        try {
            String json = ResourceGetter.getFile("rules/rules.json");
            Map<String, Choice> choiceMap =  new ObjectMapper().readValue(json, HashMap.class);
            System.out.println(choiceMap.get("1"));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, String.format("There was a problem reading the rules from the json file."));
        }
        return null;
    }
}
