package menu.controller;

import menu.utils.Utils;
import menu.view.InputView;

import java.util.List;

public class InputController {

    public static List<String> getInputCoachNames() {
        try{
            String input = InputView.inputCoachNames();
            return Utils.separator(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputCoachNames();
        }
    }

    public static List<String> getInputCantEat(String coach) {
        try{
            String input = InputView.inputCantEat(coach);
            return Utils.separator(input);
        }catch (IllegalArgumentException e) {
            e.getMessage();
            return getInputCantEat(coach);
        }
    }
}
