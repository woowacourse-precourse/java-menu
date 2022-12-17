package menu.utils;

public class Constants {

    // 에러 관련
    public static final String EXCEPTION_PREFIX = "[ERROR] : ";
    public static final String ERROR_WRONG_NAME = EXCEPTION_PREFIX
        + "이름의 길이는 2이상 4이하여야 합니다.";
    public static final String ERROR_WRONG_COACH_NUMBER = EXCEPTION_PREFIX
        + "코치들의 인원 수는 2이상 5이하여야 합니다.";
    public static final String ERROR_WRONG_FOOD_NUMBER = EXCEPTION_PREFIX
        + "못먹는 메뉴는 0이상 2이하여야 한다.";
    public static final String ERROR_INPUT = EXCEPTION_PREFIX
        + "잘못된 입력입니다. 다시 입력해주세요";
    public static final String KOREAN = ".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*";

    // 출력 형식 관련
    public static final String PREFIX = "[ " ;
    public static final String DELIMITER = " | ";
    public static final String POSTFIX = " ]";
    public static final String CATEGORY_PREFIX = "[ 카테고리 | ";

}
