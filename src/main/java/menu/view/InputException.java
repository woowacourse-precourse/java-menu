package menu.view;

import menu.util.CoachCode;
import menu.util.ExceptionMsg;
import menu.util.PrintMsg;

import java.util.List;

public class InputException {
    public static void nullException(String userInput) {
        if (isNull(userInput)) {
            throw new IllegalArgumentException(ExceptionMsg.NULL.getMsg());
        }
    }

    public static boolean isNull(String userInput) {
        if (userInput == null || userInput.isBlank() || userInput.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void notEndFormatException(String userInput) {
        if (userInput.endsWith(PrintMsg.COMMA.getMsg())) {
            throw new IllegalArgumentException(ExceptionMsg.NAME_SIZE.getMsg());
        }
    }

    public static void notMemberSizeException(int size) {
        if (!(size >= CoachCode.MIN_MEMBER.getCode()
                && size <= CoachCode.MAX_MEMBER.getCode())) {
            throw new IllegalArgumentException(ExceptionMsg.MEMBER_SIZE.getMsg());
        }
    }

    public static void notCoachFormatException(List<String> userList) {
        for (String user : userList) {
            nullException(user);
            notCoachNameSizeException(user.length());
        }
    }

    public static void notCoachNameSizeException(int size) {
        if (!(size >= CoachCode.MIN_NAME.getCode()
        && size <= CoachCode.MAX_NAME.getCode())) {
            throw new IllegalArgumentException(ExceptionMsg.COACH_NAME.getMsg());
        }
    }

    public static void notFoodsSizeException(int size) {
        if (!(size >= CoachCode.MIN_FOOD.getCode()
        && size <= CoachCode.MAX_FOOD.getCode())) {
            throw new IllegalArgumentException(ExceptionMsg.FOOD_SIZE.getMsg());
        }
    }
}
