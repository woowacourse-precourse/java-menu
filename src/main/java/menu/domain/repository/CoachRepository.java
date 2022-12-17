package menu.domain.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Coach;

public class CoachRepository {
    private CoachRepository() {
    }

    private static final List<Coach> coaches = new ArrayList<>();

    public static List<Coach> coaches() {
        return Collections.unmodifiableList(coaches);
    }

    public static void add(Coach coach) {
        coaches.add(coach);
    }

}
