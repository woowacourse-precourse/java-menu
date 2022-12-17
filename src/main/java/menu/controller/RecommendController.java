package menu.controller;

import menu.service.InputService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.Arrays;

import static menu.constant.InputMessage.GET_COACH_NAME;
import static menu.constant.InputMessage.START_RECOMMEND;

public class RecommendController implements Controller{

    private final InputService inputService = new InputService();
    private final OutputView outputView = new OutputView();

    @Override
    public void process() {
        outputView.printMessage(START_RECOMMEND.getValue());
        String[] coachNames = inputService.getUserInput(inputService::getCoachNames);
    }
}
