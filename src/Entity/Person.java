package Entity;
import Entity.Type.Gender;
public abstract class Person {
    private String name;
    private int age;
    private Gender gender;
    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank()) { throw new IllegalArgumentException("Name cannot be null or blank");}
        this.name = name;
    }
    public int getAge() { return age; }
    public void setAge(int age) {
        if (age > 100) { throw new IllegalArgumentException("Age cannot be greater than 100");}
        if (age < 0) { throw new IllegalArgumentException("Age cannot be negative"); }
        this.age = age;
    }
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }
}
