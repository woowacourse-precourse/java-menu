package menu.controller;

import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    public void run() {
        OutputView.printMenuRecommendationStart();
        CoachRepository.addCoachName(InputView.readCoachName());
        for (Coach coach : CoachRepository.coaches()) {
            coach.addCoachDoNotEatFood(InputView.readCoachDoNotEatFood(coach));
        }
    }
}
