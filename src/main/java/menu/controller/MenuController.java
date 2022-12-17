package menu.controller;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final Category category;
    private List<Coach> coaches;
    public MenuController() {
        this.category = new Category();
    }
    public void start() {
        try {
            OutputView.printStart();
            boolean keep = true;
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
            for (String coach : input) {
                coaches.add(new Coach(coach));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readCoach();
        }
    }

}