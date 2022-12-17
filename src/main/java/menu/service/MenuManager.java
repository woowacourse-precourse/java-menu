package menu.service;

import menu.domain.Coach;
import menu.domain.CoachRepository;

import java.util.List;

public class MenuManager {
    public void saveCoach(List<String> coachNames) {
        for (String coachName : coachNames) {
            CoachRepository.add(new Coach(coachName));
        }
    }

    public List<String> findAllCoachNames() {
        return CoachRepository.getAllNames();

    }

    public void saveHatingMenus(List<String> hatingMenus, List<String> coachNames) {
    }
}
