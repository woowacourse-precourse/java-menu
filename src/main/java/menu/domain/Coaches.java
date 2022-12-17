package menu.domain;

import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validateSize(coaches);
        this.coaches = coaches;
    }

    private void validateSize(List<Coach> coaches) {
        if (!isValidSize(coaches.size())) {
            throw new IllegalArgumentException("[ERROR] 코치는 2명 ~ 5명까지 가능합니다.");
        }
    }

    private static boolean isValidSize(int size) {
        return 2 <= size && size <= 5;
    }
}
