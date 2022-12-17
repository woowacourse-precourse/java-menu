package menu.repository;

import menu.domain.coach.Coach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachRepository {
    private static final List<Coach> coaches = new ArrayList<>();

    public static void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public static List<Coach> getAllCoaches() {
        return Collections.unmodifiableList(coaches);
    }
}
