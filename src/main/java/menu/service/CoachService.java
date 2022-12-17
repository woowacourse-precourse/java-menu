package menu.service;

import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.domain.Food;
import menu.domain.FoodRepository;

public class CoachService {
    public void initialize(String[] coachNames) {
        for (String coachName : coachNames) {
            CoachRepository.addCoach(new Coach(coachName));
        }
    }
}
