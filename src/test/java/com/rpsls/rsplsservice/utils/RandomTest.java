package com.rpsls.rsplsservice.utils;

import org.junit.Assert;
import org.junit.Test;

public class RandomTest {
    @Test
    public void testGetRandomNumber() {
        int number = Random.numberBetweenZeroAnd(5);
        int number2 = Random.numberBetweenZeroAnd(5);
        int number3 = Random.numberBetweenZeroAnd(5);

        Assert.assertTrue((number >= 0) && (number <=4));
        Assert.assertTrue((number2 >= 0) && (number2 <=4));
        Assert.assertTrue((number3 >= 0) && (number3 <=4));
    }
}
