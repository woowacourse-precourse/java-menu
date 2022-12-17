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
        Recorder recorder = new Recorder(recommendHistory);
        for (int i = 0; i < Day.sizeOfValues(); i++) {
            CategoryRecommender categoryRecommender = new CategoryRecommender(recommendHistory);
            Category category = categoryRecommender.recommend();
            recorder.recordCategory(category);
            MenuRecommender menuRecommender = new MenuRecommender(hateMenusByCoach, recommendHistory);
            Map<String, String> menuByCoach = menuRecommender.recommendByCoach(category);
            recorder.recordMenuByCoach(menuByCoach, coachNames);
        }
    }
}