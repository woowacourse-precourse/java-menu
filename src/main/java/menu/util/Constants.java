package menu.util;

import java.util.List;

public class Constants {
    public static final List<String> DAY_OF_WEEK = List.of("월요일", "화요일", "수요일", "목요일", "금요일");

    public static final int MAX_NUMBER_OF_DUPLICATE = 2;

    public static final int INIT_RECOMMENDED_COUNT_VALUE = 0;

    public static final int MAX_NUMBER_OF_COACH = 5;
    public static final int MIN_NUMBER_OF_COACH = 2;
    public static final int MAX_LENGTH_OF_NAME = 4;
    public static final int MIN_LENGTH_OF_NAME = 2;
    public static final int MAX_NUMBER_OF_HATE_MENU = 2;
    public static final int MIN_NUMBER_OF_HATE_MENU = 0;

    public static final String DEFAULT_ERROR_MESSAGE = "[ERROR]";
    public static final String CANNOT_FOUND_CATEGORY = "[ERROR] 해당 미션이 존재하지 않습니다.";
    public static final String NUMBER_OF_COACH_ERROR = "코치는 최소 %d명, 최대 %d명을 입력해야합니다.";
    public static final String LENGTH_OF_NAME_ERROR = "코치의 이름은 최소 %d글자, 최대 %d글자이다.";
    public static final String NUMBER_OF_HATE_MENU_ERROR = "각 코치는 최소 %d개, 최대 %d개의 못 먹는 메뉴를 가질 수 있습니다.";

    public static final String COACH_NAMES_INPUT_SEPARATOR = ",";
    public static final String HATE_MENUS_INPUT_SEPARATOR = ",";

    public static final String START_GUIDE = "점심 메뉴 추천을 시작합니다.";
    public static final String NAME_INPUT_GUIDE = "\n코치의 이름을 입력해 주세요. (%s 로 구분)";
    public static final String HATE_MENU_INPUT_GUIDE = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    public static final String START_RESULT_GUIDE = "\n메뉴 추천 결과입니다.";
    public static final String END_RESULT_GUIDE = "\n추천을 완료했습니다.";

    // 각자 양식이 바뀔 수 있으므로 따로 지정
    public static final String WEEK_GUIDE_DELIMITER = " | ";
    public static final String WEEK_GUIDE_PREFIX = "[ ";
    public static final String WEEK_GUIDE_SUFFIX = " ]";

    public static final String CATEGORY_GUIDE_DELIMITER = " | ";
    public static final String CATEGORY_GUIDE_PREFIX = "[ ";
    public static final String CATEGORY_GUIDE_SUFFIX = " ]";

    public static final String RECOMMEND_GUIDE_DELIMITER = " | ";
    public static final String RECOMMEND_GUIDE_PREFIX = "[ ";
    public static final String RECOMMEND_GUIDE_SUFFIX = " ]";

}
