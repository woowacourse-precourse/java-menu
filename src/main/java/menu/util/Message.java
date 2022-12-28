package menu.util;

public enum Message {
    ERROR_COACH_NAME_LENGTH("[ERROR] 코치이름의 길이를 확인해주세요"),
    ERROR_COACH_COUNT("[ERROR] 코치는 두 명과 다섯명 사이로 입력해주세요"),
    ERROR_MENU_COUNT("[ERROR] 못먹는 메뉴는 두 개까지만 입력가능합니다");

    private final String errMessage;

    Message(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return this.errMessage;
    }
}
