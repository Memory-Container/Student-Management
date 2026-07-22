package Entity;
import Entity.Type.Gender;
import Entity.Type.LetterGrade;

public class Student extends Person {
    private String ID;
    private double avgScore;
    private String originalClass;
    private String address;
    public String getName() { return super.getName(); }
    public Gender getGender() { return super.getGender(); }
    public int getBirthYear() { return super.getBirthYear(); }
    public void setID(String ID) {
        if (ID.length() < 7) { throw new IllegalArgumentException("ID must have at least 7 characters"); }
        this.ID = ID;
    }
    public void setOriginalClass(String originalClass) {
        if (originalClass == null) { throw new IllegalArgumentException("Class code cannot be null"); }
        if (originalClass.length() < 7 || originalClass.length() > 14) {
            throw new IllegalArgumentException("Class code must be at least 7 characters and less than 14 characters");
        }
        this.originalClass = originalClass;
    }
    public void setAddress(String address) {
        if (address == null) { throw new IllegalArgumentException("Address cannot be null"); }
        this.address = address;
    }
    public void setAvgScore(double avgScore) {
        if (avgScore < 0 || avgScore > 10) {
            throw new IllegalArgumentException("Score value must be between 0 and 10");
        }
        this.avgScore = avgScore;
    }
    public String getAddress() { return address; }
    public double getAvgScore() { return Math.ceil(avgScore * 100) / 100; }
    public LetterGrade getGPA() { return LetterGrade.fromScore(getAvgScore()); }
    public String getID() { return ID; }
    public String getOriginalClass() { return originalClass; }

    @Override
    public String toString() {
        return  getName()+"|"+
                getBirthYear()+"|"+
                getGender()+"|"+
                getID()+"|"+
                getOriginalClass()+"|"+
                getGPA()+"|"+
                getAvgScore()+"|"+
                getAddress();
    }
}
