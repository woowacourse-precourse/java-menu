package menu.error;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2022. 12. 17.
 */
public enum CoachErrorCode {

    COACH_NAME_IS_MIN_2_MAX_4("코치의 이름은 최소 2글자, 최대 4글자이다."),
    COACH_COUNT_MIN_2_MAX_5("코치들은 최소 2명, 최대 5명까지 식사를 함께 할 수 있다."),
    HATE_MENU_INPUT_ONLY_KOREAN("코치가 못 먹는 음식은 한글만 입력할 수 있습니다."),
    HATE_MENU_SIZE_0_TO_2("코치가 못 먹는 메뉴는 최소 0개, 최대 2개이다."),
    COAch_NAME_IS_ONLY_KOREAN("코치의 이름은 한글만 입력할 수 있다.");

    private final String message;

    CoachErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
