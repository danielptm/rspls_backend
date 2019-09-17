package com.rpsls.rsplsservice.utils;

public class Random {
    private Random() {

    }

    /**
     * Returns a random number between 0 and an upper limit.
     * @return random int
     */
    public static int numberBetweenZeroAnd(int upperLimit) {
        return (int) Math.floor((upperLimit * Math.random()));

    }

    public static String reduceComputerResult(String choice) {
        int computerChoice = Integer.parseInt(choice);
        return String.valueOf(  (int) Math.floor(Double.valueOf(computerChoice)/100 * 4) + 1);
    }
}
