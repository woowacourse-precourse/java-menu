package menu.view;

public enum Format {
    SEPARATOR("|"),
    FIRST_BRACKET("["),
    LAST_BRACKET("]");

    private final String format;

    Format(String format) {
        this.format = format;
    }

    public String getFormat() {
        return this.format;
    }
}
