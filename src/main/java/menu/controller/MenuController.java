package menu.controller;

import java.util.ArrayList;
import java.util.List;

import menu.model.Recommender;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Menu;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    List<Coach> coaches = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    Recommender recommender = new Recommender();
    
    private static final int recommendDays = 5;

    public void run() {
        init();
        outputView.printServiceResult();
        for (int day = 0; day < recommendDays; day ++) {
            Category category = recommender.recommendCategory();
            for (Coach coach : coaches) {
                recommendMenu(category, coach);
            }
        }
        outputView.printRecommendMenuResult(recommender.getCategoryCheckList());
        for (Coach coach : coaches) {
            outputView.printRecommendMenuResultByCoach(coach.getName(), coach.getAlreadyRecommended());
        }
        outputView.printServiceEnd();
    }

    public void init() {
        outputView.printServiceStart();
        outputView.printInputCoachName();
        while (true) {
            try {
                List<String> inputCoachName = inputView.readCoachName();
                validateCoachCount(inputCoachName);
                validateCoachNameLength(inputCoachName);
                for (String coachName : inputCoachName) {
                    outputView.printInputCoachNotEat(coachName);
                    coaches.add(new Coach(coachName ,inputView.readCoachNotEat()));
                }
                return ;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public void recommendMenu(Category category, Coach coach) {
        Menu food = category.getCategoryMenu();
        String recommendedFood;
        do {
            recommendedFood = recommender.recommendFood(food.getFoods());
        } while (coach.isAlreadyRecommended(recommendedFood) || coach.isNotEat(recommendedFood));
        coach.addFood(recommendedFood);
    }

    private void validateCoachCount(List<String> inputCoachName) {
        if (inputCoachName.size() < 2) {
            throw new IllegalArgumentException("코치는 최소 2명 이상 입력해야 합니다.");
        } else if (inputCoachName.size() > 5) {
            throw new IllegalArgumentException("코치는 최대 5명까지 입력할 수 있습니다.");
        }
    }
    
    private void validateCoachNameLength(List<String> inputCoachName) {
        for (String coachName : inputCoachName) {
            if (coachName.length() < 2) {
                throw new IllegalArgumentException("코치의 이름은 최소 2글자 이상 입력해야 합니다.");
            } else if (coachName.length() > 4) {
                throw new IllegalArgumentException("코치의 이름은 최대 4글자까지 입력할 수 있습니다.");
            }
        }
    }
}
