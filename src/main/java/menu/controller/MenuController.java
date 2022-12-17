package menu.controller;

import menu.domain.Coach;

import java.util.List;

import static menu.view.InputView.*;
import static menu.view.OutputView.*;

public class MenuController {
    private final Coach coach;

    public MenuController(){
        this.coach = new Coach();
    }
    public void start() {
        try {
            init();
            List<String> coaches = creatCoaches();
        } catch (IllegalArgumentException error) {
            printErrorMessage(error.getMessage());
        }
    }

    private List<String> creatCoaches() {
        return coach.makeCoaches(getCoachName());
    }

    private void init() {
        printStartMessage();
    }
}
