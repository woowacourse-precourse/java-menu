package controller;

import service.Service;
import view.InputView;
import view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Service service = new Service();

    public void control() {
        init();
        play();
        end();
    }
}
