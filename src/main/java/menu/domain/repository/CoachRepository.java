package menu.domain.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

    public static boolean deleteByName(String name) {
        return coaches.removeIf(element -> Objects.equals(element.getName(), name));
    }

    public static void deleteAll() {
        coaches.clear();
    }

    public static Coach findByName(String name) {
        return coaches.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

}
