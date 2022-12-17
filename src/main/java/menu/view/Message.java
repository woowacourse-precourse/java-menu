package menu.view;

public enum Message {

    ERROR("[ERROR] %s");

    Message(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
