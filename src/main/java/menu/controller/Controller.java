package menu.controller;

import menu.model.domain.Category;
import menu.model.domain.Food;
import menu.model.service.CoachService;
import menu.model.service.FoodService;
import menu.view.InputView;
import menu.view.OutputView;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private final FoodService foodService = new FoodService();
    private final CoachService coachService = new CoachService();
    private final LunchController lunchController = new LunchController();

    public void run() {

        initApplication();
        lunchController.inputLunchAndRun(coachService, foodService);
    }


    public void initApplication() {
        saveFoods(foodService);
    }

    public void saveFoods(FoodService foodService) {
        List<String> japan = Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
        List<String> korea = Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
        List<String> china = Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
        List<String> asia = Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
        List<String> america = Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");

        for (String foodName : japan) {
            foodService.join(new Food(foodName, Category.JAPAN));
        }

        for (String foodName : korea) {
            foodService.join(new Food(foodName, Category.KOREA));
        }

        for (String foodName : china) {
            foodService.join(new Food(foodName, Category.CHINA));
        }

        for (String foodName : asia) {
            foodService.join(new Food(foodName, Category.ASIA));
        }

        for (String foodName : america) {
            foodService.join(new Food(foodName, Category.AMERICA));
        }
    }

    /**
     * 일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
     * 한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
     * 중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
     * 아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
     * 양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
     * @param missionService
     */
}
