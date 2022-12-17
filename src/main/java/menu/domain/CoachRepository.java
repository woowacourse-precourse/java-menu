package menu.domain;

import java.util.*;

public class CoachRepository {
    private static final List<Coach> COACHES = new ArrayList<>();

    public static List<Coach> coaches() {
        return Collections.unmodifiableList(COACHES);
    }

    public static void addcoach(Coach coach) {
        COACHES.add(coach);
    }

    public static Coach getcoachByName(String name) {
        Optional<Coach> first = coaches().stream().filter(coach -> coach.getName().equals(name)).findFirst();
        return first.orElse(null);
    }
}
