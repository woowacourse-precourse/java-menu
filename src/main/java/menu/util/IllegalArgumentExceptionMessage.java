package menu.util;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public enum IllegalArgumentExceptionMessage {
    INPUT_COACH_LENGTH_MIN("코치는 최소 " + Command.NUMBER_OF_COACH_MIN.getData() + "명 이상 입력해야 합니다.")
    , INPUT_COACH_LENGTH_MAX("코치는 최대 " + Command.NUMBER_OF_COACH_MAX.getData() + "명 이하로 입력해야 합니다.")
    , INPUT_COACH_NAME_LENGTH_MIN("코치의 이름은 최소 " + Command.COACH_NAME_LENGTH_MIN.getData() + "자 이상 입력해야 합니다.")
    , INPUT_COACH_NAME_LENGTH_MAX("코치의 이름은 최대 " + Command.COACH_NAME_LENGTH_MAX.getData() + "자 이하로 입력해야 합니다.")
    , NO_MATCHING_MENU("일치하는 메뉴가 없습니다.")
    , NO_MATCHING_COACH("일치하는 코치가 없습니다.")
    , HATE_MENU_SIZE("싫어하는 메뉴는 최대 " + Command.HATE_MENU + "개 까지 가능합니다.")
    ;

    private final String message;

    IllegalArgumentExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}