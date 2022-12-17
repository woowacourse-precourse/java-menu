package menu.domain;

import static menu.constant.SystemConstant.*;

public class Coach {

    private final String coachName;

    public Coach(String coachName) {
        validateNameLength(coachName);
        this.coachName = coachName;
    }

    public String getCoachName() {
        return coachName;
    }

    private void validateNameLength(String coachName) {
        if (coachName.length() > COACH_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX + "코치의 이름은 최대 " + COACH_NAME_MAX_LENGTH + "자 입니다.");
        }
        if (coachName.length() < COACH_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX + "코치의 이름은 최소 " + COACH_NAME_MIN_LENGTH + "자 입니다.");
        }
    }
}
