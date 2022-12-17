package menu.repository;

import menu.domain.coach.Coach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoachRepository {
    private static final HashMap<String, Coach> coaches = new HashMap<>();

    public static void addCoach(Coach coach) {
        coaches.put(coach.getName(), coach);
    }

    public static List<Coach> getAllCoaches() {
        return new ArrayList<>(coaches.values());
    }
}
