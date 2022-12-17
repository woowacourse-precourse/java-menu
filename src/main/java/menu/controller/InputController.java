package menu.controller;

import menu.view.InputView;

public class InputController {

    public static void registerCouch() {
        while (true) {
            try {
                String names = InputView.readNames();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
