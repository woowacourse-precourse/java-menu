package menu.controller;

import menu.service.InputService;
import menu.view.OutputView;

import java.util.List;

import static menu.constant.InputMessage.START_RECOMMEND;

public class RecommendController implements Controller{

    private final InputService inputService = new InputService();
    private final OutputView outputView = new OutputView();

    @Override
    public void process() {
        outputView.printMessage(START_RECOMMEND.getValue());
        List<String> coachNames = inputService.getUserInput(inputService::getCoachNames);
        for (String coachName : coachNames) {
            inputService.getUserInputWithParam(inputService::getNotEatFoods, coachName);
        }
    }
}
