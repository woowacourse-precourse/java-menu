package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {
    private static final List<Coach> coaches = new ArrayList<>();

    public static List<Coach> coaches() {
        return coaches;
    }

    public static void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public static List<Coach> getCoaches() {
        return coaches;
    }
}
