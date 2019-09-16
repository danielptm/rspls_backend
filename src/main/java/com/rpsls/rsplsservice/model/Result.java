package com.rpsls.rsplsservice.model;

public class Result {
    private String result;
    private String player;
    private String computer;
    private String playerName;

    public Result() {
    }

    public Result(String result, String player, String computer, String playerName) {
        this.result = result;
        this.player = player;
        this.computer = computer;
        this.playerName = playerName;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }

    public String getResult() {
        return result;
    }

    public String getPlayer() {
        return player;
    }

    public String getComputer() {
        return computer;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Result{");
        sb.append("result='").append(result).append('\'');
        sb.append(", player='").append(player).append('\'');
        sb.append(", computer='").append(computer).append('\'');
        sb.append(", playerName='").append(playerName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
