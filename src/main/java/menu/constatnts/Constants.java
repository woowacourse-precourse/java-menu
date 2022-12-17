package menu.constatnts;

public class Constants {
    public static final int COACH_NUMS_MIN = 2;
    public static final int COACH_NUMS_MAX = 5;
    public static final int COACH_NAMES_LENGTH_MIN = 2;
    public static final int COACH_NAMES_LENGTH_MAX = 4;
    public static final int COACH_HATE_FOOD_MAX = 2;
    public static final int CATEGORY_START_NUM = 1;
    public static final int CATEGORY_END_NUM = 5;
    public static final String SPLITTER_INPUT = ",";

    public static final String PRINT_START_MSG = "점심 메뉴 추천을 시작합니다.";
    public static final String PRINT_RECOMMEND_FOOD_MSG = "메뉴 추천 결과입니다.";
    public static final String PRINT_RECOMMEND_FOOD_END_MSG = "추천을 완료했습니다.";
    public static final String PRINT_SUBJECT_DAY_MSG = "구분";
    public static final String PRINT_CATEGORY_DAY_MSG = "카테고리";
    public static final String SCAN_COACH_NAMES_MSG = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String SCAN_COACH_HATES_FOOD_MSG = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public static final String ERROR_COACH_NAME_SPLITTER = "[ERROR]코치의 이름은 ,로 구분하여 2명이상 5명 이하 입니다.";
    public static final String ERROR_COACH_NUMS = "[ERROR] 코치 인원수가 너무 적거나 많습니다.";
    public static final String ERROR_COACH_NAME_LENGTH = "[ERROR] 코치의 이름 길이는 2이상 4이하 입니다.";
    public static final String ERROR_COACH_FOODS_SPLITTER = "[ERROR]싫어하는 음식을 잘못 입력 하셨습니다.";
    public static final String ERROR_COACH_HATE_FOOD_MANY = "[ERROR] 싫어 하는 음식을 너무 많이 입력 하셨습니다.";
    public static final String ERROR_NONE_MENU = "[ERROR] 없는 메뉴 입니다.";
    public static final String ERROR_WEEKLY_CATEGORY_SIZE = "[ERROR] 주간 음식 카테고리가 정해진 날짜 수를 넘었습니다.";
    public static final String ERROR_NONE_CATEGORY = "[ERROR] 없는 음식 카테고리입니다.";
}
