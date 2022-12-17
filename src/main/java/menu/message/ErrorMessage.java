package menu.message;

public class ErrorMessage {

    private static final String HEADER = "[ERROR] ";

    public static final String INCORRECT_INPUT_FORMAT = HEADER + "입력값과 구분자(,)만 입력 가능합니다.";

    public static final String SAME_WORD_ENTERED_TWICE = HEADER + "같은 값을 두 번 이상 입력했습니다.";

    public static final String LESS_THAN_MINIMUM_NUMBER_OF_COACH = HEADER + "코치는 최소 2명 이상 입력해야 합니다.";
    public static final String OVER_MAXIMUM_NUMBER_OF_COACH = HEADER + "코치는 최대 5명까지 입력 가능합니다.";

    public static final String OVER_MAXIMUM_NUMBER_OF_DISLIKE_FOOD = HEADER + "못 먹는 음식은 최대 2개까지 입력 가능합니다";
}
