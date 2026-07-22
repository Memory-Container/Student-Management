package UI;

import Entity.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
    public static void exportAsFile(ArrayList<Student> students) {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.toString()).append("\n");
        }

        List<String> lines = List.of(sb.toString());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timestamp = now.format(formatter);
        String fileName = "StudentListExport(" + timestamp + ").txt";
        String userHome = System.getProperty("user.home");
        Path targetPath = Paths.get(userHome, "Downloads", fileName);
        try {
            Files.write(targetPath, lines);
            System.out.println("File successfully saved to: " + targetPath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }
    public static void run() {
        while (true) {

        }
    }
}
