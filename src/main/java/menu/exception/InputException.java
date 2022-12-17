package menu.exception;

import java.util.List;

public class InputException {
    public void validateCoachName(List<String> coachName) {
        for (String name : coachName) {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException("[ERROR] 코치의 이름은 2글자에서 4글자를 입력해야 합니다.");
            }
        }
    }

    public void validateCoachCount(List<String> coachName) {
        if (coachName.size() < 2 || coachName.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명이서 식사를 함께할 수 있습니다.");
        }
    }
}
