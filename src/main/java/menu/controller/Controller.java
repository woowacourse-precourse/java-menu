package menu.controller;

import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.domain.FoodRecommender;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    public void run() {
        OutputView.printMenuRecommendationStart();
        inputAndSaveCoachName();
        for (Coach coach : CoachRepository.coaches()) {
            inputAndSaveFood(coach);
        }
        FoodRecommender foodRecommender = new FoodRecommender();
        foodRecommender.repeatThisWeekFood();
        OutputView.printRecommendationResult(CoachRepository.coaches());
        OutputView.printMenuRecommendationEnd();
    }

    public void inputAndSaveCoachName() {
        while (true) {
            try {
                CoachRepository.addCoachName(InputView.readCoachName());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputAndSaveFood(Coach coach) {
        while (true) {
            try {
                coach.addCoachDoNotEatFood(InputView.readCoachDoNotEatFood(coach));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
