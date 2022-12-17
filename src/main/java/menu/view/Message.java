package menu.view;

public enum Message {

    ERROR("[ERROR] %s"),
    SERVICE_START("점심 메뉴 추천을 시작합니다.");

    Message(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
