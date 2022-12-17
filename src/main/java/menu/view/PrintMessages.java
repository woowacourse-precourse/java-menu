package menu.view;

public enum PrintMessages {
    SERVICE_START("점심 메뉴 추천을 시작합니다.\n"),
    INSERT_COACHES("코치의 이름을 입력해 주세요. (, 로 구분)");

    private final String message;

    PrintMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
