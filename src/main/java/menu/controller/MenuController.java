package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
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
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readCoach();
        }
    }

}