package com.rpsls.rsplsservice.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
public class PlayServiceTest {
    @Autowired
    PlayService playService;

    @Test
    public void testing() {
        playService.playRound(null, null);
    }
}
