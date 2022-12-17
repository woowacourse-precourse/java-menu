package menu.controller;

import menu.domain.coach.Coach;
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
        menuDomain.initDays();
        outputView.printMsg(PrintMsg.START.getMsg());
    }

    public void start() {
        readCoachNames();
        readCoachsCannotEat();
        doRecommand();
        printResult();
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
            List<String> foods = getFoods(coach.getName());
            menuDomain.initFoods(coach, foods);
        }
    }
    public List<String> getFoods(String coachName) {
        while (true) {
            try {
                outputView.printEmptyMsg();
                outputView.printMsg(coachName+PrintMsg.INPUT_FOODS.getMsg());
                return menuDomain.checkAndFoods(inputView.readNotEatFoods());
            } catch (IllegalArgumentException exception) {
                outputView.printMsg(exception.getMessage());
            }
        }
    }

    /**
     * 메뉴 추천을 하기위한 동작 함수
     */
    public void doRecommand() {
        menuDomain.doRecommand();
    }

    public void printResult() {
        outputView.printEmptyMsg();
        outputView.printService(menuDomain.getResult());
    }
}
