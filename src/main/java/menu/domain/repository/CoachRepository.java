package menu.domain.repository;

import menu.domain.model.Coach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachRepository {

    private static final List<Coach> coaches;

    static {
        coaches = new ArrayList<>();
    }

    private CoachRepository() {
    }

    public static void save(Coach coach) {
        coaches.add(coach);
    }

    public static List<Coach> findAll() {
        return Collections.unmodifiableList(coaches);
    }
}
