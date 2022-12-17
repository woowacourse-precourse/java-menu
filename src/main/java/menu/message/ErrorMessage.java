package menu.message;

public class ErrorMessage {
    private static final String HEADER = "[ERROR] ";
    public static final String INCORRECT_COACH_NAMES = HEADER + "올바른 코치 이름을 입력해주세요." +
            "(최소 2명, 최대 5명, 이름 길이: 2 ~ 4글자)";
    public static final String INCORRECT_ALLEGE_MENU = HEADER + "올바른 못 먹는 메뉴를 입력해주세요. (최대 2개)";
}
