package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoachRepository {

    private static final List<Coach> coachs = new ArrayList<>();

    public static void add(Coach coach) {
        coachs.add(coach);
    }

    public static List<String> getAllNames() {
        return coachs.stream().map(Coach::getName).collect(Collectors.toList());
    }

    public static Coach findByName(String coachName) {
        return coachs.stream()
                .filter(coach -> coach.getName().equals(coachName))
                .findFirst().get();
    }
}
