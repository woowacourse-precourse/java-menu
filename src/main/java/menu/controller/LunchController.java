package menu.controller;

import menu.model.domain.Category;
import menu.model.domain.Coach;
import menu.model.domain.Food;
import menu.model.service.CoachService;
import menu.model.service.FoodService;
import menu.util.*;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.*;

public class LunchController {

    private static final String MONDAY = "월요일";
    private static final String TUESDAY = "화요일";
    private static final String WEDNESDAY = "수요일";
    private static final String THURSDAY = "목요일";
    private static final String FRIDAY = "금요일";

    public void inputLunchAndRun(CoachService coachService, FoodService foodService) {
        OutputView.startLunch();

        try {
            String input = InputView.inputCoachesName();
            CoachValidator.isValidCoachName(input);
            List<String> coaches = Parser.splitInfo(input);
            //CoachGenerator.parsingCoachList(coaches, coachService);

            for (String coachName : coaches) {
                String inputFoods = InputView.inputCantEatFood(coachName);
                if (inputFoods.isEmpty()) {
                    coachService.join(new Coach(coachName, Arrays.asList(new Food("X", null))));
                } else if (!inputFoods.isEmpty()) {
                    List<String> cannotEatFoodsForString = Parser.splitInfo(inputFoods);
                    List<Food> cannotEatFoodsForFood = new ArrayList<Food>();
                    for (String foodName : cannotEatFoodsForString) {
                        Food findFoodByName = foodService.findByName(foodName);
                        cannotEatFoodsForFood.add(findFoodByName);
                    }
                    coachService.join(new Coach(coachName, cannotEatFoodsForFood));
                }
            }

            List<Category> stringCategoryMap = ParingCategory.initCategoryOrder();
//            for(Map.Entry<String, Category> entry : stringCategoryMap.entrySet()) {
//                System.out.println(entry.getKey() + " " + "카테고리: " + entry.getValue());
//            }
            ParingCategory.initFoodOrderForCoach(foodService, coachService, stringCategoryMap);

            OutputView.printResult(coachService, foodService, stringCategoryMap);
//            System.out.println("확인절차");
        }
        /**구구: 비빔밥, 김치찌개, 쌈밥, 규동, 우동 → 한식을 3회 먹으므로 불가능
         토미: 비빔밥, 비빔밥, 규동, 우동, 볶음면 → 한 코치가 같은 메뉴를 먹으므로 불가능
         제임스: 비빔밥, 김치찌개, 스시, 가츠동, 짜장면 → 매일 다른 메뉴를 먹으므로 가능
         포코: 비빔밥, 김치찌개, 스시, 가츠동, 짜장면 → 제임스와 메뉴가 같지만, 포코는 매번 다른 메뉴를 먹으므로 가능
         **/


        catch (
                IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            inputLunchAndRun(coachService, foodService);
        }

        OutputView.finishRecommend();


//                "[ 카테고리 | 한식 | 양식 | 일식 | 중식 | 아시안 ]",
//                "[ 구구 | 김치찌개 | 스파게티 | 규동 | 짜장면 | 카오 팟 ]",
//                "[ 제임스 | 제육볶음 | 라자냐 | 가츠동 | 짬뽕 | 파인애플 볶음밥 ]",
//
//        "[ 카테고리 | 한식 | 양식 | 일식 | 중식 | 아시안 ]",
//                "[ 구구 | 김치찌개 | 스파게티 | 규동 | 짜장면 | 카오 팟 ]",
//                "[ 제임스 | 제육볶음 | 라자냐 | 가츠동 | 짬뽕 | 파인애플 볶음밥 ]
    }
}










