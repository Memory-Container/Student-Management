package Entity.Type;

public enum Gender {
    Male("Male"),
    Female("Female");
    private final String displayText;
    Gender(String displayText) { this.displayText = displayText; };
    public String getDisplayText() { return displayText; }
}
