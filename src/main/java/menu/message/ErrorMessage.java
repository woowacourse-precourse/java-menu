package menu.message;

public class ErrorMessage {
    public static final String INVALID_COACH_NAME_LENGTH = "[ERROR] 코치의 이름은 2~4글자여야 합니다.";
    public static final String INVALID_COACH_COUNT = "[ERROR] 코치는 최소 2명에서 최대 5명까지 입력할 수 있습니다.";
    public static final String DUPLICATED_COACH_NAME = "[ERROR] 코치의 이름이 중복되면 안됩니다.";
    public static final String INVALID_EXCLUDE_MENU_COUNT = "[ERROR] 제외 메뉴는 0 ~ 2개까지 입력 가능합니다.";

    private ErrorMessage() {
    }
}
