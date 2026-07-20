import Controller.StudentController;
import Controller.Type.StudentProperty;
import Entity.*;
import Entity.Type.Gender;
import Entity.Type.ScoreType;
import UI.ClassCLI;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student person = new Student(
                "Diệp Đình Hiếu",
                19,
                Gender.Male,
                "25695111",
                "DHTH21D",
                new ArrayList<Score>(List.of(
                        new Score(8.67778, ScoreType.NORMAL),
                        new Score(10, ScoreType.NORMAL),
                        new Score(10, ScoreType.NORMAL),
                        new Score(10, ScoreType.MIDTERM),
                        new Score(10, ScoreType.FINAL)

                )),
                0);
        ClassCLI cli = new ClassCLI();
        cli.printStudentInfo(person);
    }
}