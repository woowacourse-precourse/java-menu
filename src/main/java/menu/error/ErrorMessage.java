package menu.error;

public class ErrorMessage {
    public static void printCoachNameLengthError() {
        System.out.println(ErrorConstant.COACH_NAME_LENGTH_ERROR_MESSAGE);
    }

    public static void printCoachNumberError() {
        System.out.println(ErrorConstant.COACH_NUMBER_ERROR_MESSAGE);
    }

    public static void printNotEatMenusError() {
        System.out.println(ErrorConstant.NOT_EAT_MENUS_ERROR_MESSAGE);
    }
}
