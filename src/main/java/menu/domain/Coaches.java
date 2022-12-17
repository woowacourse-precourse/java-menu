package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coaches {
    private final List<Coach> coaches = new ArrayList<>();

    public Coaches(final List<Coach> coaches) {
        this.coaches.addAll(coaches);
    }


    public List<Coach> getCoachList() {
        return Collections.unmodifiableList(coaches);
    }
}
