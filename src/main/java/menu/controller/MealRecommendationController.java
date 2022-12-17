package menu.controller;

import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MealRecommendationController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CoachRepository coachRepository;

    public MealRecommendationController() {
        this.coachRepository = CoachRepository.getInstance();
    }

    public void run() {
        outputView.printStartGuide();
        getAndSaveCoaches();
    }

    private void getAndSaveCoaches() {
        outputView.printNameInputGuide();
        while (true) {
            try {
                List<String> coachNames = inputView.getCoachNames();
                saveCoaches(coachNames);
            } catch(IllegalArgumentException e){
                outputView.printError(e.getMessage());
            }
        }
    }

    private void saveCoaches(List<String> names) {
        for (String name : names) {
            Coach coach = new Coach(name);
            coachRepository.save(coach);
        }
    }


}
