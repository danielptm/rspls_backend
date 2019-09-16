package com.rpsls.rsplsservice.service;

import com.rpsls.rsplsservice.model.PlayerName;
import com.rpsls.rsplsservice.utils.Random;
import org.springframework.stereotype.Service;


@Service
public class PlayerService {

    public PlayerName getRandomName() {
        String[] adjectives = new String[]{"positive", "hardworking", "helpful", "passionate", "team-oriented", "curious", "engaging"};
        String[] nouns = new String[]{"SoftwareEngineer", "JavaDeveloper", "FullstackDeveloper", "JavascriptDeveloper", "CloudEngineer"};
        int adjectiveIndex = Random.numberBetweenZeroAnd(7);
        int nounIndex = Random.numberBetweenZeroAnd(5);
        int number = Random.numberBetweenZeroAnd(100);
        PlayerName playerName = new PlayerName(adjectives[adjectiveIndex] + nouns[nounIndex] + number);
        return playerName;
    }
}
