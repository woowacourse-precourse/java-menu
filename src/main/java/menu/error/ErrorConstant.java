package menu.error;

public class ErrorConstant {
    private static final String BASE_ERROR_MESSAGE = "[ERROR] ";
    public static final String COACH_NUMBER_ERROR_MESSAGE = BASE_ERROR_MESSAGE + "코치 수는 2명에서 5명 입니다.";
    public static final String COACH_NAME_LENGTH_ERROR_MESSAGE = BASE_ERROR_MESSAGE + "코치 이름은 2글자에서 4글자 입니다.";
    public static final String NOT_EAT_MENUS_ERROR_MESSAGE = BASE_ERROR_MESSAGE + "못 먹는 메뉴는 0개에서 2개까지 입니다.";
}
