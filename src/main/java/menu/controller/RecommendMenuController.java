package menu.controller;

import menu.domain.CoachRepository;
import menu.domain.DislikeMenuRepository;
import menu.view.Input;
import menu.view.Output;

public class RecommendMenuController {
    private final Input input;
    private final Output output;

    public RecommendMenuController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void startRecommend() {
        output.printStart();
        CoachRepository coachRepository = input.getCoach();
        DislikeMenuRepository dislikeMenus = input.getDislikeFood(coachRepository);
    }
}
