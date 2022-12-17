package menu.repository;

import menu.Coach;
import menu.service.SuggestMenuService;

public class CoachRepository {

    private static final CoachRepository instance = new CoachRepository();

    private CoachRepository() {

    }

    public static CoachRepository getInstance() {
        return instance;
    }

    public void save(Coach coach) {

    }
}
