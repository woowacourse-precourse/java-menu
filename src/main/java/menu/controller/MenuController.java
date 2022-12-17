package menu.controller;

import menu.domain.Category;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final Category category;
    public MenuController() {
        this.category = new Category();
    }
    public void start() {
        try {
            OutputView.printStart();
            boolean keep = false;
            while (keep) {
                readCoach();
                keep = false;
            }
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

    private void readCoach() {
        try {
            String[] input = InputView.readCoachName();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readCoach();
        }
    }

}