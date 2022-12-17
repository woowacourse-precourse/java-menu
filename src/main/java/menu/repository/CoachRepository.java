package menu.repository;

import menu.entity.Coach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoachRepository {

//    private final Map<String, Coach> coachDB = new HashMap<>();
    private final List<Coach> coachDB = new ArrayList<>();

    private static final CoachRepository instance = new CoachRepository();

    private CoachRepository() {

    }

    public static CoachRepository getInstance() {
        return instance;
    }

    public void save(Coach coach) {
        validateDuplicateEntity(coach);
        coachDB.add(coach);
//        coachDB.put(coach.getName(), coach);
    }

    private void validateDuplicateEntity(Coach coach) {
        if (coachDB.contains(coach))
            throw new IllegalStateException("이미 존재하는 코치");
    }

    public List<Coach> findAll() {
        return new ArrayList<>(coachDB);
    }
}
