package menu.repository;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {
    private List<Coach> coaches = new ArrayList<>();
    public void save(Coach coach) {
        coaches.add(coach);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
