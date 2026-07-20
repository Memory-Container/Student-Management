package UI;

import Entity.Score;
import Entity.Student;
import Entity.Type.ScoreType;

import java.util.ArrayList;

public class ClassCLI extends CLI {
    private final int colNumberWidth = 6;
    private final int colNameWidth = 23;
    private final int colIDWidth = 10;
    private final int colAgeWidth = 5;
    private final int colGenderWidth = 8;
    private final int colRegularScoreWidth = 14;
    private final int colMidtermScoreWidth = 9;
    private final int colFinalScoreWidth = 9;
    private final int colGPAWidth = 5;
    private final int colAvgScoreWidth = 11;
    private final int totalWidth =
            colNumberWidth +
            colNameWidth +
            colIDWidth +
            colAgeWidth +
            colGenderWidth +
            colRegularScoreWidth +
            colMidtermScoreWidth +
            colFinalScoreWidth +
            colGPAWidth +
            colAvgScoreWidth;
    public static String formatScore(ArrayList<Score> scores) {
        StringBuilder resultString = new StringBuilder();
        int maxLength = 4;
        for (int i = 0; i < scores.size(); i++) {
            double value = scores.get(i).getValue();
            int padding = Math.max(0, maxLength - String.valueOf(value).length());
            if (i == 0) {
                resultString.append(" ".repeat(padding));
                resultString.append(value);
            } else {
                resultString.append("│");
                resultString.append(" ".repeat(padding));
                resultString.append(value);
            }
        }
        return resultString.toString();
    }
    public void printStudentTableHeader() {
        String hNumber = centerText("No", colNumberWidth);
        String hName = centerText("NAME", colNameWidth);
        String hId = centerText("ID", colIDWidth);
        String hAge = centerText("AGE", colAgeWidth);
        String hGender = centerText("GENDER", colGenderWidth);
        String hScore = centerText("REGULAR", colRegularScoreWidth);
        String hMidterm = centerText("MIDTERM", colMidtermScoreWidth);
        String hFinal = centerText("FINAL", colFinalScoreWidth);
        String hGpa = centerText("GPA", colGPAWidth);
        String hAvg = centerText("AVG SCORE", colAvgScoreWidth);
        String headerLine = String.format(
                "│%s│%s│%s│%s│%s│%s│%s│%s│%s│%s│",
                hNumber,
                hName,
                hId,
                hAge,
                hGender,
                hScore,
                hMidterm,
                hFinal,
                hGpa,
                hAvg
        );
        System.out.println(headerLine);
    }
    public void printStudentInfo(Student student) {
        printStudentTableHeader();
        String numbering      = centerText("01", colNumberWidth);
        String name           = " " + leftText(student.getName(), colNameWidth - 1);
        String id             = centerText(student.getID(), colIDWidth);
        String age            = centerText(String.valueOf(student.getAge()), colAgeWidth);
        String gender         = centerText(student.getGender().getDisplayText(), colGenderWidth);
        String regularScore   = centerText(formatScore(student.getScores(ScoreType.NORMAL)), colRegularScoreWidth);
        String midtermScore   = centerText(formatScore(student.getScores(ScoreType.MIDTERM)), colMidtermScoreWidth);
        String finalScore     = centerText(formatScore(student.getScores(ScoreType.FINAL)), colFinalScoreWidth);
        String gpa            = centerText(String.valueOf(student.getGPA().getDisplayText()), colGPAWidth);
        String avgScore       = centerText(String.valueOf(student.getAvgScore()), colAvgScoreWidth);
        String infoLine = String.format(
                "│%s│%s│%s│%s│%s│%s│%s│%s│%s│%s│",
                numbering,
                name,
                id,
                age,
                gender,
                regularScore,
                midtermScore,
                finalScore,
                gpa,
                avgScore
        );
        System.out.println(infoLine);
    }
}
