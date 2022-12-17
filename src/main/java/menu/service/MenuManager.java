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
}
