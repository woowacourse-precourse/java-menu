package menu.controller;

import menu.domain.CoachRepository;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    public void run() {
        OutputView.printMenuRecommendationStart();
        CoachRepository.addCoachName(InputView.readCoachName());
    }
}
