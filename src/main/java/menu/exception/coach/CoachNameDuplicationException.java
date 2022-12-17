package menu.exception.coach;

import menu.exception.BaseException;

public class CoachNameDuplicationException extends BaseException {

    public static final String COACH_NAME_DUPLICATED = "코치 이름은 중복될 수 없습니다.";

    public CoachNameDuplicationException() {
        super(COACH_NAME_DUPLICATED);
    }
}
