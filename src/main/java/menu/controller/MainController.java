package menu.controller;

import menu.domain.Category;
import menu.service.CategoryService;
import menu.service.RecommendationService;
import menu.view.InputView;
import menu.view.OutputView;
import menu.view.constant.OutputPhrase;

public class MainController {
    private static class InstanceHolder {
        private static final MainController INSTANCE = new MainController();
    }

    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();
    private CategoryService categoryService = CategoryService.getInstance();
    private RecommendationService recommendationService = RecommendationService.getInstance();

    private MainController(){}

    public static MainController getInstance() {
        return MainController.InstanceHolder.INSTANCE;
    }

    public void start() {
        outputView.printPhrase(OutputPhrase.START.getPhrase());
    }
}
