package menu.domain.repository;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.utils.ExceptionType;

public class CoachRepository {

    private static final List<Coach> coachRepository = new ArrayList<>();

    public static void addCoach(Coach coach) {
        if (!coachRepository.contains(coach)) {
            coachRepository.add(coach);
        }
    }

    public static Coach findCoachByCoachName(String name) {
        return coachRepository.stream()
                .filter(coach -> coach.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionType.IS_NOT_IN_COACH.toString()));
    }
}
