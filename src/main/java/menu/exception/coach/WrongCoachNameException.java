package menu.exception.coach;

import static menu.validator.CoachValidator.COACH_NAME_MAX_LENGTH;
import static menu.validator.CoachValidator.COACH_NAME_MIN_LENGTH;

import menu.exception.BaseException;

public class WrongCoachNameException extends BaseException {

    public static final String WRONG_COACH_NAME_LENGTH =
            "코치의 이름은 최소 " + COACH_NAME_MIN_LENGTH + "글자, 최대 " + COACH_NAME_MAX_LENGTH + "글자여야 합니다.";

    public WrongCoachNameException() {
        super(WRONG_COACH_NAME_LENGTH);
    }
}
