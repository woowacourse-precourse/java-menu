package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches() {
        this.coaches = new ArrayList<>();
    }

    public void add(Coach coach) {
        coaches.add(coach);
    }

    public List<Coach> getCoaches() {
        return this.coaches;
    }
}
