package week13.task3;

public class TextEditor {
    TextFormatter formatter;

    public void setFormatter(TextFormatter formatter) {
        this.formatter = formatter;
    }

    public String formatText(String text) {
        return formatter.formatText(text);
    }
}
