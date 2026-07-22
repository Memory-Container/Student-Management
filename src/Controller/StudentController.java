package Controller;
import Controller.Type.StudentProperty;
import Entity.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentController implements Controller<Student, StudentProperty> {
    protected ArrayList<Student> studentsList;

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
                    case BIRTH_YEAR -> String.valueOf(student.getBirthYear()).equals(searchValue);
                    case ORIGINAL_CLASS -> student.getOriginalClass().equalsIgnoreCase(searchValue);
                    case GPA -> String.valueOf(student.getGPA().getDisplayText()).equals(searchValue);
                    case AVG_SCORE -> String.valueOf(student.getAvgScore()).equals(searchValue);
                    case ADDRESS ->  student.getAddress().contains(searchValue);
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean studentNotExists(String ID) {
        return studentsList.stream().anyMatch(student -> student.getID().equals(ID));
    }
    @Override
    public boolean add(Student newStudent) {
        if (newStudent == null) { return false; }
        if (studentNotExists(newStudent.getID())) {
            studentsList.add(newStudent);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Student oldStudent) {
        return studentsList.removeIf(student -> student.getID().equals(oldStudent.getID()));
    }

    @Override
    public boolean update(Student targetStudent, StudentProperty property, Object newValue) {
        if (targetStudent == null || property == null) {
            throw new IllegalArgumentException("Student and Property cannot be null");
        }
        if (studentNotExists(targetStudent.getID())) {
            return false;
        }
        switch (property) {
            case ID:
                targetStudent.setID((String) newValue);
                break;
            case NAME:
                targetStudent.setName((String) newValue);
                break;
            case BIRTH_YEAR:
                targetStudent.setBirthYear((int) newValue);
                break;
            case GENDER:
                targetStudent.setGender((String) newValue);
                break;
            case AVG_SCORE:
                targetStudent.setAvgScore((double) newValue);
                break;
            case ADDRESS:
                targetStudent.setAddress((String) newValue);
                break;
            case ORIGINAL_CLASS:
                targetStudent.setOriginalClass((String) newValue);
                break;
            default:
                throw new UnsupportedOperationException("Unknown property: " + property);
        }
        return true;
    }

    public Student findByID(String ID) {
        Optional<Student> foundStudent = studentsList.stream().filter(student -> student.getID().equals(ID)).findFirst();
        return foundStudent.orElse(null);
    }
}
