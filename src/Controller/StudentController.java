package Controller;
import Controller.Type.StudentProperty;
import Entity.Student;

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
                    case BIRTH_YEAR -> String.valueOf(student.getBirthYear()).equals(searchValue);
                    case ORIGINAL_CLASS -> student.getOriginalClass().equalsIgnoreCase(searchValue);
                    case GPA -> String.valueOf(student.getGPA().getDisplayText()).equals(searchValue);
                    case AVG_SCORE -> String.valueOf(student.getAvgScore()).equals(searchValue);
                    case ADDRESS ->  student.getAddress().equalsIgnoreCase(searchValue);
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean studentNotExists(Student targetStudent) {
        return studentsList.stream().anyMatch(student -> student.getID().equals(targetStudent.getID()));
    }
    @Override
    public boolean add(Student newStudent) {
        if (newStudent == null) { return false; }
        if (studentNotExists(newStudent)) {
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
        if (studentNotExists(targetStudent)) {
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
                targetStudent.setAvgScore((Double) newValue);
            default:
                throw new UnsupportedOperationException("Unknown property: " + property);
        }
        return true;
    }
}
