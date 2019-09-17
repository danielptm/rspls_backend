package com.rpsls.rsplsservice.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rpsls.rsplsservice.model.Player;
import com.rpsls.rsplsservice.model.Result;
import com.rpsls.rsplsservice.utils.ResourceGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PlayService {

    private static final Logger LOGGER = Logger.getLogger(ResourceGetter.class.getName());

    private ResultsService resultsService;
    private ComputerService computerService;

    @Autowired
    public PlayService(ResultsService resultsService, ComputerService computerService) {
        this.resultsService = resultsService;
        this.computerService = computerService;
    }


    public Result playRound(Player player) {
        Player computer = new Player();
        computer.setName("computer");
        computer.setChoiceId(computerService.getComputerChoice());

        try {
            String json = ResourceGetter.getFile("rules/rules.json");

            JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
            JsonArray winsArray = jsonObject.get(player.getChoiceId()).getAsJsonObject().get("wins").getAsJsonArray();
            JsonArray losesArray = jsonObject.get(player.getChoiceId()).getAsJsonObject().get("loses").getAsJsonArray();

            if (player.getChoiceId().equals(computer.getChoiceId())) {
                return new Result("tie", player.getChoiceId(), computer.getChoiceId(), player.getName());
            } else {
                for (JsonElement jsonElement : winsArray) {

                    String winId = jsonElement.getAsJsonObject().get("id").getAsString();
                    String computerChoiceId = computer.getChoiceId();

                    if (winId.equals(computerChoiceId)) {
                        return new Result("win", player.getChoiceId(), computer.getChoiceId(), player.getName());
                    }
                }
                //If it does not find it in the ^ loop, then return a lose result.
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("There was a problem reading the rules from the json file."));
        }
        return new Result("lose", player.getChoiceId(), computer.getChoiceId(), player.getName());
    }
}
