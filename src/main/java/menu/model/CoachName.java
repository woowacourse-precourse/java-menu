package menu.model;

import java.util.List;

public class CoachName {

    private static final Integer MIN_NAME_SIZE = 2;
    private static final Integer MAX_NAME_SIZE = 4;

    private final List<String> coachNames;

    public CoachName(List<String> coachNames) {
        validate(coachNames);
        this.coachNames = coachNames;
    }

    public List<String> getCoachNames() {
        return coachNames;
    }

    private void validate(List<String> coachNames) {
        for (String coachName : coachNames) {
            if (!isValidCoachNameLength(coachName)) {
                throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자 입니다.");
            }
        }
    }

    private boolean isValidCoachNameLength(String name) {
        return MIN_NAME_SIZE <= name.length() && name.length() <= MAX_NAME_SIZE;
    }
}
