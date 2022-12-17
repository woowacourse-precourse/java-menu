package menu.controller;

import menu.service.RecommendService;
import menu.view.OutputView;

public class RecommendController {

    private final RecommendService recommendService;

    public RecommendController() {
        this.recommendService = new RecommendService();
    }

    public void run() {
        OutputView.printStartMessage();
    }
}
