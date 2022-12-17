package menu.domain;

import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validate(coaches);
        this.coaches = coaches;
    }

    private void validate(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("코치 명수 오류");
        }
    }
}
