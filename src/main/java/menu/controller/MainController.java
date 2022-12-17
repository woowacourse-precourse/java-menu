package menu.controller;

import menu.domain.Coach;
import menu.domain.MenuRecommender;
import menu.repository.CoachRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MainController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final CoachRepository coachRepository = new CoachRepository();

    public void run() {
        outputView.printStartMessage();

        List<String> coachNames = inputView.readCoachNames();
        for (String coachName : coachNames) {
            List<String> noEatFoods = inputView.readNoEatFoods(coachName);
            Coach coach = new Coach(coachName, noEatFoods);
            coachRepository.save(coach);
        }

        MenuRecommender menuRecommender = new MenuRecommender(coachRepository);
        menuRecommender.run();

        outputView.printEndMessage();
    }
}
