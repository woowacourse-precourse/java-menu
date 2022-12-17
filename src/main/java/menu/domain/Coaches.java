package menu.domain;

import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
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
}
