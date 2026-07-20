package Controller;

import Controller.Type.StudentProperty;
import Entity.Student;
import Entity.Type.ScoreType;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class StudentController implements Controller<Student, StudentProperty> {
    protected ArrayList<Student> studentsList;
    public StudentController(ArrayList<Student> student) { this.studentsList = student; }

    @Override
    public ArrayList<Student> getAll() { return studentsList; }

    @Override
    public Student getAtIndex(int index) {
        return (index >= 0 && index < studentsList.size()) ? studentsList.get(index) : null;
    }

    @Override
    public ArrayList<Student> filterBy(StudentProperty property, String searchValue) {
        if (property == null || searchValue == null) { return new ArrayList<>(); }
        return studentsList.stream()
                .filter(student -> switch (property) {
                    case ID -> student.getID().equalsIgnoreCase(searchValue);
                    case NAME -> student.getName().contains(searchValue);
                    case GENDER -> student.getGender().getDisplayText().equalsIgnoreCase(searchValue);
                    case AGE -> String.valueOf(student.getAge()).equals(searchValue);
                    case SCORE -> String.valueOf(student.getScores(ScoreType.NORMAL)).equalsIgnoreCase(searchValue);
                    case MIDTERM -> String.valueOf(student.getScores(ScoreType.MIDTERM)).equalsIgnoreCase(searchValue);
                    case FINALS -> String.valueOf(student.getScores(ScoreType.FINAL)).equalsIgnoreCase(searchValue);
                    case GPA -> String.valueOf(student.getGPA().getDisplayText()).equals(searchValue);
                    case AVG_SCORE -> String.valueOf(student.getAvgScore()).equals(searchValue);
                    case CAN_ATTEND_FINAL -> String.valueOf(student.canAttendFinal()).equalsIgnoreCase(searchValue);
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public boolean add(Student newStudent) {
        if (newStudent == null) { return false; }
        boolean studentExists = studentsList.stream().anyMatch(student -> student.getID().equals(newStudent.getID()));
        if (!studentExists) {
            studentsList.add(newStudent);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Student oldStudent) {
        return studentsList.removeIf(student -> student.getID().equals(oldStudent.getID()));
    }
}
