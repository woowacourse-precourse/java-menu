package menu.controller;

import menu.service.RecommendingService;

public class RecommendingController extends AbstractController {
    @Override
    public void doProcess() {
        RecommendingService.doRecommending();
    }
}
