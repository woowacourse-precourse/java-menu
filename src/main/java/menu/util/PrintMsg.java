package menu.util;

public enum PrintMsg {
    COMMA(","),
    START("점심 메뉴 추천을 시작합니다."),
    INPUT_COACH("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_FOODS("(이)가 못 먹는 메뉴를 입력해 주세요.");
    private final String msg;

    PrintMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
