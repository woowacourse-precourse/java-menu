package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MenuController extends Controller{

    public MenuController(InputView inputView, OutputView outputView) {
        super(inputView, outputView);
    }


    @Override
    public void run() {
        start();

    }

    public void start() {
        outputView.printStartMessage();
    }
}
