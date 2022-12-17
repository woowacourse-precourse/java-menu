package menu.controller;

import menu.model.domain.Category;
import menu.model.domain.Coach;
import menu.model.domain.Food;
import menu.model.service.CoachService;
import menu.model.service.FoodService;
import menu.util.*;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LunchController {

    public void inputLunchAndRun(CoachService coachService, FoodService foodService) {
        OutputView.startLunch();

        try {
            String input = InputView.inputCoachesName();
            CoachValidator.isValidCoachName(input);
            List<String> coaches = Parser.splitInfo(input);
            //CoachGenerator.parsingCoachList(coaches, coachService);

            for (String coachName : coaches) {
                String inputFoods = InputView.inputCantEatFood(coachName);
                List<String> cannotEatFoodsForString = Parser.splitInfo(inputFoods);
//                Coach findCoachByName = coachService.findByName(coach);
//                System.out.println("findCoachByName: " + findCoachByName.getName());
                List<Food> cannotEatFoodsForFood = new ArrayList<Food>();
                for (String foodName : cannotEatFoodsForString) {
                    Food findFoodByName = foodService.findByName(foodName);
                    cannotEatFoodsForFood.add(findFoodByName);
                }
                coachService.join(new Coach(coachName, cannotEatFoodsForFood));
            }
            ///
            List<String> allNames = coachService.findAllNames();
//            for (String name : allNames) {
//                Coach byName = coachService.findByName(name);
//                System.out.println("이름: " + byName.getName());
//                for(Food food : byName.getCannotEatFoods()) {
//                    System.out.println("못먹는거 :" + food.getName());
//                }
//            }

            Map<String, Category> stringCategoryMap = ParingCategory.initCategoryOrder(foodService, coachService);
            for(Map.Entry<String, Category> entry : stringCategoryMap.entrySet()) {
                System.out.println(entry.getKey() + " " + "카테고리: " + entry.getValue());
            }
        }
//            return menuController.RunAndReturnCommand(input, pairService, missionService, memberService);
        catch (
                IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            inputLunchAndRun(coachService, foodService);
        }

        OutputView.finishRecommend();
    }
}