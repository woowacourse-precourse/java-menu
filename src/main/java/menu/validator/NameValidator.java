package menu.validator;

import java.util.List;

public class NameValidator {
    private static final int COACH_MIN_COUNT = 2;
    private static final int COACH_MAX_COUNT = 5;
    private static final int NAME_MAX_LENGTH = 4;
    private static final int NAME_MIN_LENGTH = 2;

    private static final String ERROR_COACH_COUNT = "[ERROR] 코치는 최소 2명 이상, 최대 5명 이하로 입력해야 합니다.";
    private static final String ERROR_NAME_LENGTH = "[ERROR] 코치의 이름은 2~4글자 입니다.";

    public void validate(List<String> names) {
        validateCoachCount(names);
        validateNameRange(names);
    }

    private void validateCoachCount(List<String> names) {
        int coachCount = names.size();
        if(coachCount < COACH_MIN_COUNT || coachCount > COACH_MAX_COUNT) {
            throw new IllegalArgumentException(ERROR_COACH_COUNT);
        }
    }

    private void validateNameRange(List<String> names) {
        for(int i=0; i<names.size(); i++) {
            String name = names.get(i);
            if(name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(ERROR_NAME_LENGTH);
            }
        }
    }
}
