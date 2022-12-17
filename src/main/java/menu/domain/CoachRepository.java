package menu.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CoachRepository {
    private static Map<String, Coach> coaches = new LinkedHashMap<>();

    public static void save(Coach coach) {
        coaches.put(coach.getName(), coach);
    }

    public static List<Coach> findAllCoach() {
        return coaches.keySet().stream()
                .map(key -> coaches.get(key))
                .collect(Collectors.toList());
    }

    public static Coach findCoachByName(String name) {
        return coaches.get(name);
    }
}
