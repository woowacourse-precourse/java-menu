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

    public int getCachesSize() {
        return coaches.size();
    }

    public void pickMenus(PickCategory pickCategory) {
        for (Coach coach : coaches) {
            coach.makePickMenu(pickCategory);
        }
    }
}
