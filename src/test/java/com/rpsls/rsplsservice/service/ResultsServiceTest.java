package com.rpsls.rsplsservice.service;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
public class ResultsServiceTest {

    @Autowired
    S3Client s3Client;

    @Test
    public void testGet10MostRecentResults() {
        String sb = "[{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"}]";
        S3Client s3Client = Mockito.mock(S3Client.class);

        Mockito.when(s3Client.getResultsFile())
                .thenReturn(sb);

        ResultsService resultsService = new ResultsService(s3Client);

        Assert.assertEquals(10, resultsService.getMostRecent10Results().size());
    }

    @Ignore
    public void testing() {
        String sb = "[{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"},{\"result\":\"WIN\",\"player\":\"1\",\"computer\":\"2\",\"playerName\":\"dantheman\"}]";
        s3Client.writeContentsToS3(sb);
        System.out.println("**************************");
        System.out.println(s3Client.getResultsFile());
    }
}
