package menu.domain;

import java.util.Collections;
import java.util.List;

public class Coaches {
    private static final int COACH_MIN_SIZE = 2;
    private static final int COACH_MAX_SIZE = 5;

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validateSize(coaches);
        this.coaches = coaches;
    }

    public List<Coach> get() {
        return Collections.unmodifiableList(coaches);
    }

    private void validateSize(List<Coach> coaches) {
        if (coaches.size() < COACH_MIN_SIZE || coaches.size() > COACH_MAX_SIZE) {
            throw new IllegalArgumentException("코치는 2~5명 사이만 입력 가능합니다.");
        }
    }
}
