package menu.message;

public class ErrorMessage {

    private static final String HEADER = "[ERROR] ";
    public static final String INCORRECT_INPUT_FORMAT = HEADER + "코치의 이름과 구분자(,)만 입력 가능합니다.";
    public static final String LESS_THAN_MINIMUM_NUMBER_OF_COACH = HEADER + "코치는 최소 2명 이상 입력해야 합니다.";
    public static final String OVER_MAXIMUM_NUMBER_OF_COACH = HEADER + "코치는 최대 5명까지 입력 가능합니다.";
}
