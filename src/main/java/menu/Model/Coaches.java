package menu.Model;

import java.util.ArrayList;
import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches() {
        coaches = new ArrayList<>();
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
