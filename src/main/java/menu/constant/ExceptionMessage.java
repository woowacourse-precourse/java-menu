package menu.constant;

import menu.util.EnumUtil;

public enum ExceptionMessage implements EnumUtil {
    ERROR("[ERROR] ")
    , WRONG_COACH_COUNT(ERROR.message + "코치는 최소 %d명, 최대 %d명까지 입력할 수 있습니다.\n")
    , WRONG_COACH_NAME_LENGTH(ERROR.message + "코치의 이름은 %d글자~%d글자 사이로 입력할 수 있습니다.\n");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return message;
    }
}
