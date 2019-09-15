package com.rpsls.rsplsservice.utils;

public class Random {
    private Random() {

    }

    /**
     * Returns a random number between 1 and 5 inclusive.
     * @return random int
     */
    public static int numberBetweenOneAndFive() {
        return (int) Math.floor((5 * Math.random()));

    }
}
