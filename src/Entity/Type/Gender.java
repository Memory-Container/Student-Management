package Entity.Type;

public enum Gender {
    Male("Male"),
    Female("Female");
    private final String displayText;
    Gender(String displayText) { this.displayText = displayText; };
    public String getDisplayText() { return displayText; }
    public static Gender fromDisplayText(String text) {
        if (text == null) { return null; }
        for (Gender gender : Gender.values()) {
            if (gender.getDisplayText().equalsIgnoreCase(text.trim())) { return gender; }
        }
        return null;
    }
}
