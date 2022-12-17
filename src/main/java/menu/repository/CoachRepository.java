package menu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Coach;

public class CoachRepository {
    private static List<Coach> coaches = new ArrayList<>();

    public static void addAll(List<Coach> newCoaches) {
        coaches.addAll(newCoaches);
    }

    public static List<Coach> coaches() {
        return Collections.unmodifiableList(coaches);
    }

    public static int getIndex(Coach coach) {
        return coaches.indexOf(coach);
    }

    public static void update(int index, Coach coach) {
        coaches.set(index, coach);
    }
}
