package menu.exception;

public enum GlobalExceptionMessage {
    WRONG_CATEGORY_TYPE_EXCEPTION("[ERROR] 잘못된 카테고리 번호 타입입니다."),
    WRONG_FOOD_NAME_EXCEPTION("[ERROR] 잘못된 음식 이름입니다."),
    WRONG_FOOD_NAME_PARSING_EXCEPTION("[ERROR] 잘못된 음식 이름으로 검색이 불가능합니다."),
    DUPLICATED_CATEGORY_FOOD_EXCEPTION("[ERROR] 3번 이상 중복된 카테고리입니다."),
    COACH_NAME_RANGE_EXCEPTION("[ERROR] 코치 이름의 범위는 최소 2글자, 최대 4글자입니다."),
    COACH_SIZE_EXCEPTION("[ERROR] 코치는 최소 2명, 최대 5명까지 식사할 수 있습니다.");

    private final String message;

    GlobalExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
