package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.RecommendSystem;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendSystemController {

    private RecommendSystem recommendSystem;

    public RecommendSystemController(RecommendSystem recommendSystem) {
        this.recommendSystem = recommendSystem;
    }

    public void run() {
        OutputView.printStart();

        List<String> coachNames = InputView.inputCoachName();
        List<Coach> coaches = generateCoach(coachNames);

        List<String> canNotEatFoodInput = generateCanNotEatFood(coaches);
        generateCoachCanNotEatFood(coaches, canNotEatFoodInput);

        recommendSystem.addRandomCategory();
        generateRecommendFood(coaches);

        OutputView.printResult(coaches, recommendSystem.getRecommendCategories());
        OutputView.printEndPhrase();
    }

    // 코치 리스트를 생성하는 기능
    private List<Coach> generateCoach(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for(String coachName : coachNames) {
            coaches.add(new Coach(coachName));
        }
        return coaches;
    }

    private List<String> generateCanNotEatFood(List<Coach> coaches) {
        List<String> canNotEatFoods = new ArrayList<>();
        for(Coach coach : coaches) {
            String canNotEatFood = InputView.inputCanNotEatFood(coach);
            canNotEatFoods.add(canNotEatFood);
        }
        return canNotEatFoods;
    }

    // 코치가 먹지 못하는 음식을 추가하는 기능
    private void generateCoachCanNotEatFood(List<Coach> coaches, List<String> input){
        for(int i = 0; i < coaches.size(); i++) {
            Coach coach = coaches.get(i);
            String canNotEatFood = input.get(i);
            coach.saveCanNotEatFoods(canNotEatFood);
        }
    }

    private void generateRecommendFood(List<Coach> coaches) {
        for(Coach coach : coaches) {
            recommendSystem.addRecommendMenu(coach);
        }
    }
}
