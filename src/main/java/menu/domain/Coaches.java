package menu.domain;

import java.util.Collections;
import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
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
