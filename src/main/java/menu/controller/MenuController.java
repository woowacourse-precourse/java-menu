package menu.controller;

import menu.domain.Coach;
import menu.domain.MenuDomain;
import menu.util.PrintMsg;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuDomain menuDomain;

    public MenuController(InputView inputView, OutputView outputView, MenuDomain menuDomain) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuDomain = menuDomain;
    }

    public void initMenu() {
        menuDomain.initMenu();

        outputView.printMsg(PrintMsg.START.getMsg());
    }

    public void start() {
        readCoachNames();
        readCoachsCannotEat();
    }

    public void readCoachNames() {
        menuDomain.initCoachs(getCoachNames());
    }
    public List<String> getCoachNames() {
        while (true) {
            try {
                outputView.printEmptyMsg();
                outputView.printMsg(PrintMsg.INPUT_COACH.getMsg());
                return inputView.readCoachNames();
            } catch (IllegalArgumentException exception) {
                outputView.printMsg(exception.getMessage());
            }
        }
    }

    public void readCoachsCannotEat() {
        List<Coach> coaches = menuDomain.getCoachs();
        for (Coach coach : coaches) {
            getFoods(coach.getName());
        }
    }
    public List<String> getFoods(String coachName) {
        while (true) {
            try {
                outputView.printEmptyMsg();
                outputView.printMsg(coachName+PrintMsg.INPUT_FOODS.getMsg());
                return inputView.readNotEatFoods();
            } catch (IllegalArgumentException exception) {
                outputView.printMsg(exception.getMessage());
            }
        }
    }
}
