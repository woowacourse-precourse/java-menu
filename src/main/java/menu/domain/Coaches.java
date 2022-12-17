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

    public boolean isCoachesCount(final int count) {
        return coaches.size() == count;
    }

    public String getCoachName(final int count) {
        return coaches.get(count - 1)
                .getName();
    }
}
