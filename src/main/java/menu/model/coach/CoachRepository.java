package menu.model.coach;

import java.util.List;

public class CoachRepository {

    private List<Coach> coaches;

    public void saveCoach(Coach coach) {
        coaches.add(coach);
    }
}
