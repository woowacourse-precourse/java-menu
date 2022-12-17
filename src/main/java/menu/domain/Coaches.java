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

    public void pickMenus(PickCategory pickCategory) {
        for (int i = 0 ; i < 5 ; i++) {
            for (Coach coach : coaches) {
                coach.makePickMenu(pickCategory, i);
            }
        }
    }
}
