package menu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import menu.domain.Coach;

public class CoachRepository {

    private static final List<Coach> coachRepository = new ArrayList();

    public static void addCoach(Coach coach) {
        coachRepository.add(coach);
    }

    public static List<Coach> findAll() {
        return Collections.unmodifiableList(coachRepository);
    }

    public static Optional<Coach> findCoachByName(String name) {
        return coachRepository.stream()
                .filter(coach -> name.equals(coach.getName()))
                .findFirst();
    }


}
