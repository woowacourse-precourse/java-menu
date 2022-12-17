package menu.controller;

import menu.service.CoachService;
import menu.service.InputService;
import menu.view.OutputView;

import java.util.List;

import static menu.constant.InputMessage.START_RECOMMEND;

public class RecommendController implements Controller{

    private final OutputView outputView = new OutputView();

    private final InputService inputService = new InputService();

    private final CoachService coachService = new CoachService();

    private final MenuController menuController = new MenuController();

    public RecommendController() {
        menuController.process();
    }

    @Override
    public void process() {
        outputView.printMessage(START_RECOMMEND.getValue());
        List<String> coachNames = inputService.getUserInput(inputService::getCoachNames);
        for (String coachName : coachNames) {
            List<String> notEatFoodNames = inputService.getUserInputWithParam(inputService::getNotEatFoods, coachName);
            coachService.createCoachInfo(coachName, notEatFoodNames);
        }
    }
}
