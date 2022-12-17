package menu.repository;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {
    private static List<Coach> coaches = new ArrayList<>();

    public void saveCoaches(List<Coach> coaches) {
        this.coaches.addAll(coaches);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
