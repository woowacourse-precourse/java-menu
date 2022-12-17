package menu.repository;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;

public class CoachRepository {
    private static List<Coach> coaches = new ArrayList<>();

    public static void add(Coach coach){
        coaches.add(coach);
    }

    public static void addAll(List<Coach> newCoaches){
        coaches.addAll(newCoaches);
    }
}
