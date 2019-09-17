package com.rpsls.rsplsservice.model;

import java.util.List;
import java.util.Map;

public class Rule {
    private Map<String, List<Choice>> wins;
    private Map<String, List<Choice>> loses;

    public Rule() {
    }

    public Rule(Map<String, List<Choice>> wins, Map<String, List<Choice>> loses) {
        this.wins = wins;
        this.loses = loses;
    }

    public Map<String, List<Choice>> getWins() {
        return wins;
    }

    public void setWins(Map<String, List<Choice>> wins) {
        this.wins = wins;
    }

    public Map<String, List<Choice>> getLoses() {
        return loses;
    }

    public void setLoses(Map<String, List<Choice>> loses) {
        this.loses = loses;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rule{");
        sb.append(", wins=").append(wins);
        sb.append(", loses=").append(loses);
        sb.append('}');
        return sb.toString();
    }
}
