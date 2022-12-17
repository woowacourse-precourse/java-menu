package menu.service;

import java.util.List;
import menu.domain.Coach;
import menu.domain.repository.CoachRepository;

public class SettingCoach {

    public void addCoach(String coachName) {
        CoachRepository.addCoach(new Coach(coachName));
    }

    public void addCoachCantEatMenus(String coachName, List<String> cantEatMenus) {
        Coach coach = CoachRepository.findCoachByCoachName(coachName);
        coach.addCantEatMenus(cantEatMenus);
    }
}
