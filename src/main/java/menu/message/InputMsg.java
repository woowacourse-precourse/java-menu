package menu.message;

public enum InputMsg {
    INPUT_MSG_COACHES_NAME("\n코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_MSG_HATE_FOODS("(이)가 못 먹는 메뉴를 입력해 주세요.");

    private final String message;

    InputMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
