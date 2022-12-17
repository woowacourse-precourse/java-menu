package menu.message;

public enum OutputMsg {
    OUTPUT_MSG_SERVICE_START("점심 메뉴 추천을 시작합니다.");

    private final String message;

    OutputMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
