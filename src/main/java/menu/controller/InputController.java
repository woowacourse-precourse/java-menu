package menu.controller;

import menu.domain.HateFoods;
import menu.domain.Names;
import menu.view.InputView;

public class InputController {
    InputView inputView = new InputView();

    public Names getNames() {
        while (true) {
            try {
                String inputName = inputView.getNames();
                return new Names(inputName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public HateFoods getHateFoods(String name) {
        while (true) {
            try {
                String hateFoods = inputView.getHateFoods(name);
                return new HateFoods(hateFoods);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
