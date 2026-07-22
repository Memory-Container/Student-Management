package UI;

import Entity.Student;

public class ClassCLI extends CLI {
    private static final int colNumberWidth = 6;
    private static final int colNameWidth = 23;
    private static final int colIDWidth = 10;
    private static final int colBirthYearWidth = 12;
    private static final int colGenderWidth = 8;
    private static final int colGPAWidth = 5;
    private static final int colAvgScoreWidth = 11;
    private static final int totalWidth =
            colNumberWidth +
            colNameWidth +
            colIDWidth +
            colBirthYearWidth +
            colGenderWidth +
            colGPAWidth +
            colAvgScoreWidth;
    public static void printStudentTableHeader() {
        String hNumber = centerText("No", colNumberWidth);
        String hName = centerText("NAME", colNameWidth);
        String hId = centerText("ID", colIDWidth);
        String hAge = centerText("BIRTH YEAR", colBirthYearWidth);
        String hGender = centerText("GENDER", colGenderWidth);
        String hGpa = centerText("GPA", colGPAWidth);
        String hAvg = centerText("AVG SCORE", colAvgScoreWidth);
        String headerLine = String.format(
                "│%s│%s│%s│%s│%s│%s│%s│",
                hNumber,
                hName,
                hId,
                hAge,
                hGender,
                hGpa,
                hAvg
        );
        System.out.println(headerLine);
    }
    public static void printStudentInfo(Student student) {
        printStudentTableHeader();
        String numbering      = centerText("01", colNumberWidth);
        String name           = " " + leftText(student.getName(), colNameWidth - 1);
        String id             = centerText(student.getID(), colIDWidth);
        String age            = centerText(String.valueOf(student.getBirthYear()), colBirthYearWidth);
        String gender         = centerText(student.getGender().getDisplayText(), colGenderWidth);
        String gpa            = centerText(String.valueOf(student.getGPA().getDisplayText()), colGPAWidth);
        String avgScore       = centerText(String.valueOf(student.getAvgScore()), colAvgScoreWidth);
        String infoLine = String.format(
                "│%s│%s│%s│%s│%s│%s│%s│",
                numbering,
                name,
                id,
                age,
                gender,
                gpa,
                avgScore
        );
        System.out.println(infoLine);
    }
    public static void run() {

    }
}
