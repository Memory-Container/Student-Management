package Entity.Type;

public enum LetterGrade {
    A_PLUS("A+", 4.0, 9.7),
    A("A", 4.0, 9.4),
    A_MINUS("A-", 3.7, 9.0),
    B_PLUS("B+", 3.3, 8.7),
    B("B", 3.0, 8.4),
    B_MINUS("B-", 2.7, 8.0),
    C_PLUS("C+", 2.3, 7.7),
    C("C", 2.0, 7.4),
    C_MINUS("C-", 1.7, 7.0),
    D_PLUS("D+", 1.3, 6.7),
    D("D", 1.0, 6.4),
    D_MINUS("D-", 0.7, 6.0),
    F("F", 0.0, 0);
    private final String displayName;
    private final double gradePoints;
    private final double minNumericalGrade;
    LetterGrade(String displayName, double gradePoints, double minNumericalGrade) {
        this.displayName = displayName;
        this.gradePoints = gradePoints;
        this.minNumericalGrade = minNumericalGrade;
    }
    public String getDisplayText() { return displayName; }
    public double getGradePoint() { return gradePoints; }
    public double getMinNumericalGrade() { return minNumericalGrade; }
    public static LetterGrade fromScore(double score) {
        double roundedScore = Math.ceil(score * 100.0) / 100.0;
        for (LetterGrade grade : LetterGrade.values()) {
            if (roundedScore >= grade.minNumericalGrade) { return grade; }
        }
        return F;
    }
}
