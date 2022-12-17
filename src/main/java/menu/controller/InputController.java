package menu.controller;

import java.util.List;
import menu.domain.Coaches;
import menu.utils.validator.CoachesValidator;
import menu.utils.validator.ProhibitedMenuValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class InputController {

    public static Coaches getCoaches(){
        try {
            List<String> coachNames = InputView.inputCoachNames();
            new CoachesValidator(coachNames);
            return new Coaches(coachNames);
        }catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            return getCoaches();
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
