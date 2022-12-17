package repository;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {

    private static List<Coach> coaches = new ArrayList<>();

    public static void initializeCoaches(List<Coach> newCoaches) {
        coaches.addAll(newCoaches);
    }
}
