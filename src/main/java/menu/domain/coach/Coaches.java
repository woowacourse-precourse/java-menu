package menu.domain.coach;

import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static Coaches of(List<Coach> coaches) {
        return new Coaches(coaches);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
