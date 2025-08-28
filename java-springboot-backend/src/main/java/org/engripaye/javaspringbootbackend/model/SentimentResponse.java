package org.engripaye.javaspringbootbackend.model;

public class SentimentResponse {

    private String label;
    private String score;

    public String getLabel() {
        return label;
    }

    public String getScore() {
        return score;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
