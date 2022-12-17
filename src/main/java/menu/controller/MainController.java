package menu.controller;

import menu.domain.category.Category;
import menu.domain.history.RecommendHistory;
import menu.domain.recommender.CategoryRecommender;
import menu.domain.recommender.MenuRecommender;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.Map;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputController inputController;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputController = new InputController(inputView, outputView);
    }

    public void runMain() {
        outputView.printStart();
        List<String> coachNames = inputController.readValidCoachNames();
        Map<String, List<String>> hateMenusByCoach = inputController.readValidHateMenusByCoach(coachNames);
        RecommendHistory recommendHistory = new RecommendHistory();
        CategoryRecommender categoryRecommender = new CategoryRecommender(recommendHistory);
        Category category = categoryRecommender.recommend();
        MenuRecommender menuRecommender = new MenuRecommender(hateMenusByCoach);
        for (int i = 0; i < hateMenusByCoach.size(); i++) {
            String menu = menuRecommender.recommend(category);
            System.out.println(menu);
        }
    }
}