package Entity;
import Entity.Type.Gender;
import Entity.Type.LetterGrade;
import Entity.Type.ScoreType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student extends Person {
    private String ID;
    private ArrayList<Score> scores;
    private int missedAttendance;
    private String originalClass;
    public Student(
            String name,
            int age,
            Gender gender,
            String ID,
            String originalClass,
            ArrayList<Score> score,
            int missedAttendance
    ) {
        super(name, age, gender);
        this.ID = ID;
        this.scores = score;
        this.originalClass = originalClass;
        this.missedAttendance = missedAttendance;
    }
    public void setID(String ID) { this.ID = ID; }

    public void setOriginalClass(String originalClass) {
        if (originalClass == null) { throw new IllegalArgumentException("Class code cannot be null"); }
        if (originalClass.length() < 7 || originalClass.length() > 14) {
            throw new IllegalArgumentException("Class code must be at least 7 characters and less than 14 characters");
        }
        this.originalClass = originalClass;
    }
    public void setMissedAttendance(int missedAttendance) {
        if (missedAttendance < 0) { throw new IllegalArgumentException("Missed attendance must be a positive number"); }
        this.missedAttendance = missedAttendance;
    }

    public double getAvgScore() {
        double finalizedAverage = 0;
        for (ScoreType type : ScoreType.values()) {
            double categoryAverage = scores.stream()
                    .filter(score -> score.getType() == type)
                    .mapToDouble(Score::getValue)
                    .average()
                    .orElse(0);
            finalizedAverage += categoryAverage * type.getWeight();
        }
        return Math.ceil(finalizedAverage * 100) / 100;
    }

    public boolean canAttendFinal() {
        double midTermScore = scores.stream()
                .filter(score -> score.getType() == ScoreType.MIDTERM)
                .mapToDouble(Score::getValue)
                .toArray()[0];
        return missedAttendance < 3 && (midTermScore >= 1.0);
    }

    public ArrayList<Score> getScores(ScoreType scoreType) {
        if (scores == null) { return new ArrayList<>(); }
        return scores.stream()
                .filter(score -> score.getType() == scoreType)
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public LetterGrade getGPA() { return LetterGrade.fromScore(getAvgScore()); }
    public String getID() { return ID; }
}
