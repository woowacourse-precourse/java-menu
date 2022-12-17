package menu.controller;

import menu.DTO.CoachNameDTO;
import menu.DTO.FoodCanNotEatDTO;
import menu.DTO.RecommedResultDTO;
import menu.domain.Coach;
import menu.domain.EatingTeam;
import menu.exceptionHandler.ExceptionHandler;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {

    private static final RecommedResultDTO recommedResultDTO = RecommedResultDTO.getInstance();

    public void run() {
        CoachNameDTO coachNameDTO = ExceptionHandler.input(InputView::readCoachName);
        EatingTeam eatingTeam = new EatingTeam(coachNameDTO.getCoaches());
        for (Coach coach : eatingTeam.getMembers()) {
            FoodCanNotEatDTO foodCanNotEatDTO =
                    ExceptionHandler.input(InputView::readFoodCanNotEat, coach.getName());
            foodCanNotEatDTO.getFoodsCanNotEat().forEach(coach::addFoodCanNotEat);
        }
        eatingTeam.isRecommendedMenu();
        recommedResultDTO.setResult(eatingTeam.getRecommendedMenuToCoach());
        recommedResultDTO.setCategory(eatingTeam.getCategories());
        OutputView.printResult(recommedResultDTO);
    }
}
