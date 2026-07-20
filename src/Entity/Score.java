package Entity;

import Entity.Type.ScoreType;

public class Score {
    private double value;
    private ScoreType type;
    public Score(double value, ScoreType type) {
        if (value < 0 || value > 10) {
            throw new IllegalArgumentException("Score must be between 0 and 10");
        }
        this.value = value;
        this.type = type;
    }
    public double getValue() { return Math.ceil(value * 100) / 100; }
    public void setValue(double value) { this.value = value; }
    public ScoreType getType() { return type; }
    public void setType(ScoreType type) { this.type = type; }
}