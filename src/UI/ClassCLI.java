package UI;

import Controller.StudentController; //kiên
import Controller.Type.StudentProperty;
import Entity.Student;
import Entity.Type.Gender;

import java.util.ArrayList;
import  java.util.Scanner;//kiên
public class ClassCLI extends CLI {

    // Thêm 2 biến này
    private StudentController controller;
    private Scanner scanner;
    private Object name;

    // Thêm constructor nayf
    public ClassCLI(StudentController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

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
    public static void printStudentInfo(int number, Student student) {
        //printStudentTableHeader(); // vướng header
        String numbering      = centerText(String.valueOf(number), colNumberWidth);
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
    public void run() {
        //Scanner sc = new Scanner(System.in); //Xoa để chạy thêm
        while (true){
            System.out.println("==========================");
            System.out.println("   STUDENT MANAGEMENT");
            System.out.println("==========================");
            System.out.println("1.Show all students");
            System.out.println("2.Add student");
            System.out.println("3.Search student");
            System.out.println("4.Update student");
            System.out.println("5.Delete student");
            System.out.println("0.Exit");
            System.out.print("choose: ");

           // int choice = sc.nextInt(); // xóa để chạy chức năng thêm
            //sc.nextLine(); //xóa để chạy chức năng thêm
            int choice = Integer.parseInt((scanner.nextLine()));
            switch (choice){
                case 1:
                    showStudent();
                    break;

                case 2:
                    addStudent();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // thêm chức năng xem sinh viên
    public void showStudent(){
        ArrayList<Student> students = controller.getAll();
        if (students.isEmpty()){
            System.out.println("No student found");
        }
        printStudentTableHeader();
//        for (Student student : students){  /* xoa vì mới tham số vào printStudentInfo
//            printStudentInfo(student);
//        }
        for (int i = 0; i < students.size(); i++) {
            printStudentInfo(i + 1, students.get(i));
        }
    }

    // Thêm chức năng them sinh viên
    public void addStudent(){
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Birth Year: ");
        int birthYear = Integer.parseInt(scanner.nextLine()); // đọc bằng chuỗi rồi chuyển sang giúp tăng độ an toàn

        System.out.print("Gender (Male/Female): ");
        String genderText = scanner.nextLine();
        Gender gender = Gender.fromDisplayText(genderText);

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Original Class: ");
        String originalClass = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Average Score: ");
        double avgScore = Double.parseDouble(scanner.nextLine());

        // Tạo Student
        Student student = new Student(
                name,
                birthYear,
                gender,
                id,
                originalClass,
                address,
                avgScore
        );

        boolean result = controller.add(student);
        if(result){
            System.out.println("Add successfully!");
        }else{
            System.out.println("Student already exists!");
        }
    }

    // chuc năng tìm kiếm sinh viên
    public void searchStudent(){
        System.out.println("====== SEARCH STUDENT ======");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Gender");
        System.out.println("4. Search by Birth Year");
        System.out.println("5. Search by Original Class");
        System.out.println("6. Search by GPA");
        System.out.println("7. Search by Average Score");
        System.out.println("8. Search by Address");

        System.out.print("Choose: ");
        int choice = Integer.parseInt(scanner.nextLine());
        StudentProperty property = null;

        switch (choice) {
            case 1:
                property = StudentProperty.ID;
                break;

            case 2:
                property = StudentProperty.NAME;
                break;

            case 3:
                property = StudentProperty.GENDER;
                break;

            case 4:
                property = StudentProperty.BIRTH_YEAR;
                break;

            case 5:
                property = StudentProperty.ORIGINAL_CLASS;
                break;

            case 6:
                property = StudentProperty.GPA;
                break;

            case 7:
                property = StudentProperty.AVG_SCORE;
                break;

            case 8:
                property = StudentProperty.ADDRESS;
                break;

            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("Enter search value: ");
        String keyword = scanner.nextLine();

        ArrayList<Student> result = controller.filterBy(property, keyword);
        if (result.isEmpty()){
            System.out.println("Mo student found");
            return;
        }
        printStudentTableHeader();
//        for (Student student: result){
//            printStudentInfo(student);
//        }

        for (int i = 0; i < result.size(); i++) {
            printStudentInfo(i + 1, result.get(i));
        }

    }

    // Chức năng cập nhật sinh viên
    public  void updateStudent(){
        System.out.println("Enter student ID: ");
        String id = scanner.nextLine();

        ArrayList<Student> result = controller.filterBy(StudentProperty.ID,id);
        if (result.isEmpty()){
            System.out.println("Student not found");
            return;
        }
        Student student = result.get(0);

        System.out.println("1. Name");
        System.out.println("2. Birth Year");
        System.out.println("3. Gender");
        System.out.println("4. Average Score");
        System.out.print("Choose: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1:
                System.out.print("New Name: ");
                controller.update(
                        student,
                        StudentProperty.NAME,
                        scanner.nextLine()
                );
                break;
            case 2:
                System.out.print("New Birth Year: ");
                controller.update(
                        student,
                        StudentProperty.BIRTH_YEAR,
                        Integer.parseInt(scanner.nextLine())
                );
                break;
            case 3:
                System.out.print("Gender (Male/Female): ");
                controller.update(
                        student,
                        StudentProperty.GENDER,
                        scanner.nextLine()
                );
                break;
            case 4:
                System.out.print("New Average Score: ");
                controller.update(
                        student,
                        StudentProperty.AVG_SCORE,
                        Double.parseDouble(scanner.nextLine())
                );
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        System.out.println("Update successfully.");
        }

    //chức năng xóa sinh viên
    public void deleteStudent(){

        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        ArrayList<Student> result = controller.filterBy(StudentProperty.ID,id);

        if(result.isEmpty()){
            System.out.println("Student not found.");
            return;
        }

        Student student = result.get(0);

        System.out.print("Are you sure? (Y/N): ");
        String confirm = scanner.nextLine();

        if(!confirm.equalsIgnoreCase("Y")){
            System.out.println("Delete cancelled.");
            return;
        }

        boolean deleted = controller.remove(student);

        if(deleted){
            System.out.println("Delete successfully.");
        }else{
            System.out.println("Delete failed.");
        }
    }
}


