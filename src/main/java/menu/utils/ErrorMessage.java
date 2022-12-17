package menu.utils;

public class ErrorMessage {
    private static final String ERROR_TAG = "[ERROR] ";
    public static final String COACH_NAME_NOT_RANGE = ERROR_TAG + "코치의 이름은 최소 2글자, 최대 4글자여야 합니다.";
    public static final String COACH_NAMES_COUNT = ERROR_TAG + "코치는 최소 2명, 최대 5명까지 입력해야 합니다.";
    public static final String DUPLICATE_COACH_NAME = ERROR_TAG + "중복된 코치 이름이 있습니다.";
}