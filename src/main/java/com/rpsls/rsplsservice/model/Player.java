package com.rpsls.rsplsservice.model;

public class Player {
    private String name;
    private String choiceId;

    public Player() {
    }

    public Player(String name, String choiceId) {
        this.name = name;
        this.choiceId = choiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(String choiceId) {
        this.choiceId = choiceId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player{");
        sb.append("name='").append(name).append('\'');
        sb.append(", choiceId='").append(choiceId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
