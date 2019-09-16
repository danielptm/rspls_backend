package com.rpsls.rsplsservice.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
public class ResultsServiceTest {

    @Autowired
    ResultsService resultsService;

    @Test
    public void testGet10MostRecentResults() {
        String sb = "[{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"}]";
        Assert.assertEquals(10, resultsService.getMostRecent10Results(sb).size());
    }
}
