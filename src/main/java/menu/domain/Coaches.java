package menu.domain;

import java.util.List;

public class Coaches {
    private List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
