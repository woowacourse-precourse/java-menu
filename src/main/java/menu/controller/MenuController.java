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
        
        for (Coach coach : coaches) {
            coach.printCoach();
        }
        outputView.printServiceEnd();
    }

    public void init() {
        outputView.printServiceStart();
        outputView.printInputCoachName();
        for (String coachName : inputView.readCoachName()) {
            outputView.printInputCoachNotEat(coachName);
            coaches.add(new Coach(coachName ,inputView.readCoachNotEat()));
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
}
