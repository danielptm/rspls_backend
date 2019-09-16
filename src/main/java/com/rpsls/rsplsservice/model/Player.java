package com.rpsls.rsplsservice.model;

public class Player {
    private String name;
    private String choiceId;

    public Player(Builder builder) {
        this.name = builder.name;
        this.choiceId = builder.choiceId;
    }

    public String getName() {
        return name;
    }

    public String getChoiceId() {
        return choiceId;
    }

    public static class Builder {
        private String name;
        private String choiceId;

        public Builder(String name) {
            this.name = name;
        }

        public Builder withChoiceId(String id) {
            this.choiceId = id;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
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
