package menu.repository;

import menu.Coach;
import menu.service.SuggestMenuService;

import java.util.*;

public class CoachRepository {

    private final Map<String, Coach> coachDB = new HashMap<>();

    private static final CoachRepository instance = new CoachRepository();

    private CoachRepository() {

    }

    public static CoachRepository getInstance() {
        return instance;
    }

    public void save(Coach coach) {
        if (coachDB.containsKey(coach.getName()))
            throw new IllegalStateException("이미 존재하는 코치");

        coachDB.put(coach.getName(), coach);
    }

    public List<Coach> findAll() {
        return new ArrayList<>(coachDB.values());
    }
}
