package com.rpsls.rsplsservice.service;

import com.rpsls.rsplsservice.model.Player;
import com.rpsls.rsplsservice.utils.Random;
import org.springframework.stereotype.Service;


@Service
public class PlayerService {

    public Player getRandomName() {
        String[] adjectives = new String[]{"positive", "hardworking", "helpful", "passionate", "team-oriented", "curious", "engaging"};
        String[] nouns = new String[]{"SoftwareEngineer", "JavaDeveloper", "FullstackDeveloper", "JavascriptDeveloper", "CloudEngineer"};
        int adjectiveIndex = Random.numberBetweenZeroAnd(7);
        int nounIndex = Random.numberBetweenZeroAnd(5);
        int number = Random.numberBetweenZeroAnd(100);
        Player player = new Player();
        player.setName(adjectives[adjectiveIndex] + nouns[nounIndex] + number);
        return player;
    }
}
