package menu.controller;

import menu.model.Coach;
import menu.model.MenuResult;
import menu.model.RecommendResult;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {

    private InputView inputView;
    private OutputView outputView;
    private List<Coach> coachList;
    private MenuService menuService;

    public MenuController() {
        inputView = new InputView();
        outputView = new OutputView();
        coachList = new ArrayList<>();
        menuService = new MenuService();
    }

    public void run() {
        start();
        readCoachInfo();
        recommendMenu();
        printResult();
        end();
    }

    public void recommendMenu() {
        RecommendResult recommendResult = menuService.recommendMenu(coachList);
    }

    public void start() {
        outputView.printStart();
    }

    public List<String> readCoachNames() {
        List<String> coachNames = null;
        do {
            outputView.printReadCoachNames();
            try {
                coachNames = inputView.readCoachNames();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        } while (true);
        return coachNames;
    }

    public void readImpossibleMenus(String coachName) {
        outputView.printReadImpossibleMenus(coachName);
        List<String> impossibleMenuList = inputView.readImpossibleMenus();
        coachList.add(new Coach(coachName, impossibleMenuList));
    }

    public void readCoachInfo() {
        List<String> coachNames = readCoachNames();
        for (String coachName : coachNames) {
            readImpossibleMenus(coachName);
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
