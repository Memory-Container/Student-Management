import Controller.StudentController;
import Controller.Type.StudentProperty;
import Entity.*;
import Entity.Type.Gender;
import UI.ClassCLI;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        Student person = new Student();
        person.setName("Diệp Đình Hiếu");
        person.setBirthYear(1999);
        person.setGender("Male");
        person.setID("25695111");
        person.setOriginalClass("DHKTPM21B");
        person.setAddress("X");
        person.setAvgScore(8.65);
        ClassCLI.printStudentInfo(person);
        ClassCLI.exportAsFile(new ArrayList<>(List.of(person)));
    }
}