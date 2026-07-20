package UI;

public abstract class CLI {
    public static String centerText(String text, int width) {
        if (text == null) text = "";
        if (text.length() >= width) return text.substring(0, width);
        int totalPadding = width - text.length();
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;
        return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
    }
    public static String rightText(String text, int width) {
        if (text == null) text = "";
        if (text.length() >= width) return text.substring(0, width);
        int totalPadding = width - text.length();
        return " ".repeat(totalPadding) + text;
    }
    public static String leftText(String text, int width) {
        if (text == null) text = "";
        if (text.length() >= width) return text.substring(0, width);
        int totalPadding = width - text.length();
        return text + " ".repeat(totalPadding);
    }
}
