package menu.repository;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {

    private static final List<Coach> coaches = new ArrayList<>();

    public void insertCoach(Coach coach) {
        coaches.add(coach);
    }
}
