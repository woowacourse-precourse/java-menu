package menu.controller;

import static menu.domain.coach.CoachRepository.getCoachRepositoryInstance;

import java.util.List;
import menu.domain.coach.Coach;

public class CoachController {

    public static void selectMenuByCoach(List<String> menu) {
        for (Coach coach : getCoachRepositoryInstance().getCoaches()) {
            coach.selectMenu(menu);
        }
    }
}