package domain;

import java.util.List;

public class Coaches {
    private final List<Coach> coachNames;

    public Coaches(List<Coach> coachNames) {
        validateCoachesCount(coachNames);
        this.coachNames = coachNames;
    }

    private void validateCoachesCount(List<Coach> coachNames) {
        if (coachNames.size() >= 2 && coachNames.size() <= 5) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상, 최대 5명 이하로 입력해주세요.");
    }
}
