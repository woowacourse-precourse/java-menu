package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {
    private final List<Coach> coaches = new ArrayList<>();

    private CoachRepository() {

    }

    public static CoachRepository getCoachRepositoryInstance() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {
        private static final CoachRepository INSTANCE = new CoachRepository();
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }

}
