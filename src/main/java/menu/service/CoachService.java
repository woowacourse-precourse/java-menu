package menu.service;

import menu.domain.Coach;
import menu.repository.CoachRepository;

import java.util.List;

public class CoachService {

    private final CoachRepository coachRepository = new CoachRepository();

    public void createCoachInfo(String coachName, List<String> notEatFoodNames) {
        Coach coach = new Coach(coachName, notEatFoodNames);
        coachRepository.saveCoach(coach);
    }
}
