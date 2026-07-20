package Entity.Type;

public enum ScoreType {
    NORMAL(0.20),
    MIDTERM(0.30),
    FINAL(0.50);
    private final double weight;
    ScoreType(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
}
