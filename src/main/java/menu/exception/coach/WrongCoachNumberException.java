package menu.exception.coach;

import static menu.validator.CoachValidator.COACH_MAX_NUM;
import static menu.validator.CoachValidator.COACH_MIN_NUM;

import menu.exception.BaseException;

public class WrongCoachNumberException extends BaseException {

    public static final String WRONG_COACH_NUMBER =
            "최소 " + COACH_MIN_NUM + "명, 최대 " + COACH_MAX_NUM + "명의 코치를 입력해주세요.";

    public WrongCoachNumberException() {
        super(WRONG_COACH_NUMBER);
    }
}
