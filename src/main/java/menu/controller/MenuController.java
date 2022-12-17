package menu.controller;

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
    }

    public void readCoachNames() {

    }

    public List<String> getCoachNames() {
        while (true) {
            try {
                outputView.printEmptyMsg();
                outputView.printMsg(PrintMsg.INPUT_COACH.getMsg());
                return inputView.readCoachNames();
            } catch (IllegalArgumentException exception) {

            }
        }
    }
}
