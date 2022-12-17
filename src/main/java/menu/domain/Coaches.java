package menu.domain;

import java.util.Collections;
import java.util.List;

public class Coaches {
    private static final int MIN_COACH_SIZE = 2;
    private static final int MAX_COACH_SIZE = 5;

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validateCoachesSize(coaches);
        this.coaches = coaches;
    }

    private void validateCoachesSize(List<Coach> coaches) {
        int size = coaches.size();
        if (size < MIN_COACH_SIZE  || size > MAX_COACH_SIZE) {
            throw new IllegalArgumentException("코치는 최소 2명에서 5명 사이입니다.");
        }
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }

    public Coach findByName(String name) {
        return coaches.stream()
                .filter(coach -> {
                    Coach target = new Coach(name);
                    return coach.equals(target);
                })
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 코치입니다."));
    }

    public void recommendMenus(Recommender recommender) {
        recommender.recommendMenus(this.coaches);
    }
}
