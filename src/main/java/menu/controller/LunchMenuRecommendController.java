package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class LunchMenuRecommendController {

    private InputView inputView;
    private OutputView outputView;

    private void init(){
        initView();
    }

    public void run(){

    }

    private void initView(){
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
    }

}
