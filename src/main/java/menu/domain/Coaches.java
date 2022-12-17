package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coaches {

    private List<Coach> coaches;

    public Coaches() {
        coaches = new ArrayList<>();
    }

    public void add(Coach coach) {
        coaches.add(coach);
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }
}
