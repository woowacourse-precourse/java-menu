package menu.service;

import menu.model.coach.Coach;

import java.util.List;

public class MenuRecommendService {

    public void generateCoachByCoachName(List<String> coachNames) {
        for (String coachName : coachNames) {
            Coach coach = new Coach(coachName);
        }
    }
}
