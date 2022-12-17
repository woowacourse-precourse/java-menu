package menu.util;

public enum ErrorMessage {

    MENU_SIZE_ERROR_MESSAGE("[ERROR] : 못먹는 메뉴는 0~2개만 가능합니다."),
    MENU_FORMAT_ERROR_MESSAGE("[ERROR] : 메뉴 입력 형식에 맞지 않습니다."),
    NON_FIND_MENU_ERROR_MESSAGE("[ERROR] : 해당 메뉴를 찾을 수 없습니다."),
    NAME_SIZE_OVER_ERROR_MESSAGE("[ERROR] : 이름은 최소 2글자에서 최대 5글자 이하로 입력해야 합니다."),
    COACH_SIZE_OVER_ERROR_MESSAGE("[ERROR] : 코치는 최소 2명 이상 최대 5명 이하로 입력해야 합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
