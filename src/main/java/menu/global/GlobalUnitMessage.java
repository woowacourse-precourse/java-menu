package menu.global;

public enum GlobalUnitMessage {
    ENTER(System.lineSeparator()),
    SQUARE_BRACKET_LEFT("[ "),
    SQUARE_BRACKET_RIGHT(" ]"),
    STICK_SEPARATOR(" | "),
    COMMA(",");

    private final String message;

    GlobalUnitMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
