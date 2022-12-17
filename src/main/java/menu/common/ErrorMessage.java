package menu.common;

public class ErrorMessage {
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String COACH_NAME_LENGTH_ERROR = ERROR_PREFIX + "코치의 이름은 최소 2글자, 최대 4글자입니다.";
    public static final String INVALID_MENU_CODE = ERROR_PREFIX + "존재하지 않는 음식 카테고리 코드입니다.";
    public static final String INVALID_MENU = ERROR_PREFIX + "존재하지 않는 음식 이름입니다.";
    public static final String DUPLICATED_MAX_NUMBER = ERROR_PREFIX + "최대 값이 두개 이상 존재합니다.";
    public static final String DUPLICATED_MIN_NUMBER = ERROR_PREFIX + "최소 값이 두개 이상 존재합니다.";
    public static final String COACH_NAME_DUPLICATED = ERROR_PREFIX + "동일한 코치를 입력 할 수 없습니다.";
    public static final String COACHES_UNDER_MIN_SIZE = ERROR_PREFIX + "코치는 최소 2명 이상 입력해야 합니다.";
    public static final String COACHES_OVER_MAX_SIZE = ERROR_PREFIX + "코치는 최대 5명 까지 입력 가능 합니다.";
    public static final String AVOID_MENU_OVER_MAX_SIZE = ERROR_PREFIX + "못먹는 메뉴는 최대 2개만 입력 가능 합니다.";
    public static final String MENU_NAME_DUPLICATED = ERROR_PREFIX + "동일한 메뉴를 입력 할 수 없습니다.";

}
