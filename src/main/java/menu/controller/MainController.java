package menu.controller;

import menu.domain.category.Category;
import menu.domain.day.Day;
import menu.domain.history.RecommendHistory;
import menu.domain.recommender.CategoryRecommender;
import menu.domain.recommender.MenuRecommender;
import menu.domain.recorder.Recorder;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.Map;

public class MainController {

    private final OutputView outputView;
    private final InputController inputController;

    public MainController(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        this.inputController = new InputController(inputView, outputView);
    }

    public void runMain() {
        outputView.printStart();
        List<String> coachNames = inputController.readValidCoachNames();
        Map<String, List<String>> hateMenusByCoach = inputController.readValidHateMenusByCoach(coachNames);
        RecommendHistory recommendHistory = new RecommendHistory();
        recommendAndRecord(coachNames, hateMenusByCoach, recommendHistory);
        outputView.printRecommendedResult(Day.valuesAsList(), recommendHistory.getMenuByCoach(), recommendHistory.getCategories());
    }

    private void recommendAndRecord(List<String> coachNames, Map<String, List<String>> hateMenusByCoach, RecommendHistory recommendHistory) {
        for (int i = 0; i < Day.sizeOfValues(); i++) {
            Recorder recorder = new Recorder(recommendHistory);
            Category category = recommendCategory(recommendHistory);
            recorder.recordCategory(category);
            Map<String, String> menuByCoach = recommendMenuByCoach(hateMenusByCoach, recommendHistory, category);
            recorder.recordMenuByCoach(menuByCoach, coachNames);
        }
    }

    private static Map<String, String> recommendMenuByCoach(Map<String, List<String>> hateMenusByCoach, RecommendHistory recommendHistory, Category category) {
        MenuRecommender menuRecommender = new MenuRecommender(hateMenusByCoach, recommendHistory);
        return menuRecommender.recommendByCoach(category);
    }

    private Category recommendCategory(RecommendHistory recommendHistory) {
        CategoryRecommender categoryRecommender = new CategoryRecommender(recommendHistory);
        return categoryRecommender.recommend();
    }
}