package menu.repository;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;

public class CoachRepository {

    private static final List<Coach> coachRepository = new ArrayList();

    public static void addCoach(Coach coach) {
        coachRepository.add(coach);
    }

}
