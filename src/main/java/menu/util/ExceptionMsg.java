package menu.util;

public enum ExceptionMsg {
    ERROR("[ERROR] "),
    NULL("아무 값도 입력하지 않았습니다."),
    COACH_NAME("코치 이름은 최소 2글자에서 최대 4글자입니다."),
    MEMBER_SIZE("멤버는 최소 2명, 최대 5명까지 식사할 수 있습니다."),
    FOOD_SIZE("음식은 최소0개, 최대 2개까지만 입력 가능합니다."),
    NAME_SIZE("코치 이름이 잘못된 입력 형식입니다."),
    NOT_MENU("메뉴에 없는 음식이 입력되었습니다.");

    private final String msg;

    ExceptionMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return ERROR.msg + msg;
    }
}
