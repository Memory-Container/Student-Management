import Controller.StudentController;
import Controller.Type.StudentProperty;
import Entity.*;
import Entity.Type.Gender;
import UI.ClassCLI;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Student person = new Student("Diệp Đình Hiếu", 1900, Gender.Male, "25695111", "DHKTPM21B", "xxxxxx", 8.65);
//        ClassCLI.printStudentInfo(person);
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(
                "Diệp Đình Hiếu",
                1900,
                Gender.Male,
                "25695111",
                "DHKTPM21B",
                "xxxxxx",
                8.65
        ));
        students.add(new Student(
                "Lý Đặng Minh Kiên",
                1900,
                Gender.Male,
                "25690000",
                "DHKHMT21B",
                "yyyyyy",
                10
        ));

        StudentController controller = new StudentController((students));
        ClassCLI ui = new ClassCLI(controller);
        ui.run();
    };
}