package menu;

import java.util.List;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<Coach> getCoaches() {
        return this.coaches;
    }
}
