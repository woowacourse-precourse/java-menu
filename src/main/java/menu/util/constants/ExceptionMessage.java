package menu.util.constants;

public class ExceptionMessage {

    public static final String PREFIX = "[ERROR] ";

    public static final String COACH_NAME_NOT_EMPTY = PREFIX + "코치의 이름은 공백일 수 없습니다.";
    public static final String COACH_NAME_LENGTH = PREFIX + "코치의 이름은 최소 2글자, 최대 4글자이여야 합니다.";
    public static final String COACH_NAME_DUPLICATE = PREFIX + "코치의 이름은 중복될 수 없습니다.";
    public static final String COACH_NUMBER = PREFIX + "코치는 최소 2명, 최대 5명까지 등록할 수 있습니다.";

    public static final String NOT_EAT_FOOD_NUMBER = PREFIX + "못 먹는 음식은 최소 0개, 최대 2개여야 합니다.";
    public static final String NOT_EAT_FOOD_DUPLICATE = PREFIX + "못 먹는 음식은 중복될 수 없습니다.";

    public static final String NOT_MATCHING_FOOD = PREFIX + "일치하는 음식이 없습니다.";
    public static final String NOT_MATCHING_CATEGORY = PREFIX + "코드와 일치하는 카테고리를 찾을 수 없습니다.";

    public static final String NOT_FOUND_COACH = PREFIX + " 코치를 찾을 수 없습니다.";
    public static final String NOT_FOUND_NOT_EAT_FOODS = PREFIX + "해당 코치의 못 먹는 음식들을 찾을 수 없습니다.";

}
