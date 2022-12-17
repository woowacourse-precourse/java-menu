package menu.service;

import menu.domain.Coach;
import menu.domain.CoachRepository;

public class CoachService {
    public void initialize(String[] coachNames) {
        CoachRepository.deleteAll();
        for (String coachName : coachNames) {
            CoachRepository.addCoach(new Coach(coachName));
        }
    }

    public void addInedibleFood(String coachName, String[] foodNames) {
        CoachRepository.getCoachByName(coachName).addInedibleFood(foodNames);
    }

    public void addRecommendedFood(String coachName, String foodName) {
        CoachRepository.getCoachByName(coachName).addRecommendedFood(foodName);
    }
}
