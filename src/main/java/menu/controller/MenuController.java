package menu.controller;

import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

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

    public void generateCoachList() {
        List<Coach> coaches = inputView.readCoaches();

    }

}
