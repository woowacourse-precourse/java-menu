package menu.repository;

import menu.domain.Coach;

import java.util.List;

public class CoachRepository {
    private List<Coach> coaches;

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }
}
