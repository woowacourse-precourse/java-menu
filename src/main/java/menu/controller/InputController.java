package menu.controller;

import java.util.List;
import menu.utils.validator.CoachValidator;
import menu.utils.validator.ProhibitedMenuValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class InputController {

    public static List<String> getCoachNames(){
        try {
            List<String> coachNames = InputView.inputCoachNames();
            new CoachValidator(coachNames);
            return coachNames;
        }catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            return getCoachNames();
        }
    }

    public static List<String> getProhibitedMenus(String coachName){
        try {
            List<String> prohibitedMenus = InputView.inputProhibitedFoods(coachName);
            new ProhibitedMenuValidator(prohibitedMenus);
            return prohibitedMenus;
        }catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            return getProhibitedMenus(coachName);
        }
    }

}
