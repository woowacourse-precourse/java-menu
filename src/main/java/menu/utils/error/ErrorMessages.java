package menu.utils.error;

public enum ErrorMessages {

    INVALID_NUMBER_OF_UNEATABLE_FOODS("먹지 못하는 메뉴는 최소 0개, 최대 2개 입력 가능합니다."),
    INVALID_NUMBER_OF_COACH("코치는 최소 2명, 최대 5명까지 입력 가능합니다."),
    DUPLICATED_COACH_NAME("코치의 이름은 중복되어선 안됩니다."),
    DUPLICATED_FOOD_NAME("음식의 이름은 중복되어선 안됩니다."),
    INPUT_CORRECT_DELIMITER("입력은 정확히 \',\'로 구분해 주세요."),
    NOT_EXIST_FOOD("존재하지 않는 음식 이름입니다."),
    INVALID_COACH_NAME("코치의 이름은 최소 2글자, 최대 4글자 입니다."),
    ;

    private final String message;

    ErrorMessages(final String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
