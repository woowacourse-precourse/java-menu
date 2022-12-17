package menu.repository;

import menu.domain.coach.Coach;

import java.util.HashMap;

public class CoachRepository {
    private static final HashMap<String, Coach> coaches = new HashMap<>();

    public static void addCoach(Coach coach) {
        coaches.put(coach.getName(), coach);
    }
}
