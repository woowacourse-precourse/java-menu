package menu.view;

import menu.util.CoachCode;
import menu.util.ExceptionMsg;
import menu.util.PrintMsg;

import java.util.List;

public class InputException {
    public static void nullException(String userInput) {
        if (userInput == null || userInput.isBlank() || userInput.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMsg.NULL.getMsg());
        }
    }

    public static void notEndFormatException(String userInput) {
        if (userInput.endsWith(PrintMsg.COMMA.getMsg())) {
            throw new IllegalArgumentException("코치 이름이 잘못된 입력 형식입니다.");
        }
    }

    public static void notMemberSizeException(int size) {
        if (!(size >= CoachCode.MIN_MEMBER.getCode()
                && size <= CoachCode.MAX_MEMBER.getCode())) {
            throw new IllegalArgumentException("멤버는 최소 2명, 최대 5명까지 식사할 수 있습니다.");
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
            throw new IllegalArgumentException("코치 이름은 최소 2글자에서 최대 4글자입니다.");
        }
    }
}
