package menu.controller;

import menu.view.OutputView;

import static menu.constant.InputMessage.START_RECOMMEND;

public class RecommendController implements Controller{

    private final OutputView outputView = new OutputView();

    @Override
    public void process() {
        outputView.printMessage(START_RECOMMEND.getValue());

    }
}
