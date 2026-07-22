package Entity;
import Entity.Type.Gender;
public abstract class Person {
    private String name;
    private int birthYear;
    private Gender gender;
    public String getName() { return name; }
    public void setName(String name) {
        if (name.length() < 3) { throw new IllegalArgumentException("Name must be at least 3 characters long"); }
        if (name.isBlank()) { throw new IllegalArgumentException("Name cannot be null or blank");}
        this.name = name;
    }
    public int getBirthYear() { return birthYear; }
    public void setBirthYear(int birthYear) {
        if (birthYear > 10000) { throw new IllegalArgumentException("Birth year cannot be greater than 10000");}
        if (birthYear < 1800) { throw new IllegalArgumentException("Birth year cannot be less than 1800"); }
        this.birthYear = birthYear;
    }
    public Gender getGender() { return gender; }
    public boolean setGender(String value) {
        Gender gender = Gender.fromDisplayText(value);
        if (gender != null) {
            this.gender = gender;
            return true;
        }
        return false;
    }
}
