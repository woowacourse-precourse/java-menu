package menu.controller;

import menu.model.domain.Coach;
import menu.model.domain.Food;
import menu.model.service.CoachService;
import menu.model.service.FoodService;
import menu.util.CoachValidator;
import menu.util.Parser;
import menu.util.Validator;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LunchController {

    private final CoachService coachService = new CoachService();
    private final FoodService foodService = new FoodService();
    private final LunchController lunchController = new LunchController();

    public String inputLunchAndRun() {
        try {
            OutputView.startLunch();

            String input = InputView.inputCoachesName();
            CoachValidator.isValidCoachName(input);
            List<String> coaches = Parser.splitInfo(input);
            for(String coach : coaches) {
                String inputFoods = InputView.inputCantEatFood(coach);
                List<String> cannotEatFoodsForString = Parser.splitInfo(inputFoods);
                Coach findCoachByName = coachService.findByName(coach);
                List<Food> cannotEatFoodsForFood = new ArrayList<Food>();
                for (String foodName : cannotEatFoodsForString) {
                    Food findFoodByName = foodService.findByName(foodName);
                    cannotEatFoodsForFood.add(findFoodByName);
                }
                coachService.saveCannotEatFood(findCoachByName, cannotEatFoodsForFood);
            }


            MenuValidator.isRightMenu(input);
            return menuController.RunAndReturnCommand(input, pairService, missionService, memberService);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputMenuAndRun();
        }
    }

}
