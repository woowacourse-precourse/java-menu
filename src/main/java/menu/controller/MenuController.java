package menu.controller;

import menu.model.Coach;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {

    private InputView inputView;
    private OutputView outputView;
    private List<Coach> coachList;

    public MenuController() {
        inputView = new InputView();
        outputView = new OutputView();
        coachList = new ArrayList<>();
    }

    public void run() {
        start();
        readCoachInfo();
        printResult();
        end();
    }

    public void start() {
        outputView.printStart();
    }

    public void readCoachInfo() {
        outputView.printReadCoachNames();
        List<String> coachNames = inputView.readCoachNames();
        for (String coachName : coachNames) {
            outputView.printReadImpossibleMenus(coachName);
            List<String> impossibleMenuList = inputView.readImpossibleMenus();
            coachList.add(new Coach(coachName, impossibleMenuList));
        }
    }

    public void printResult() {
        outputView.printResultHead();
        outputView.printResultBody();
    }

    public void end() {
        outputView.printEnd();
    }

}
