package menu.service;

import menu.exception.CoachValidator;
import menu.exception.MenuValidator;
import menu.view.InputView;

public class ValidationService {
    public static String takeCoachNames() {
        InputView inputView = new InputView();
        String coachNames = inputView.readCoachNames();

        try {
            CoachValidator.validate(coachNames);
            return coachNames;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + "\n");
            return takeCoachNames();
        }
    }

    public static String takeNotEatMenus(String coachName) {
        InputView inputView = new InputView();
        String notEatMenus = inputView.readNotEatMenus(coachName);

        try {
            MenuValidator.validate(notEatMenus);
            return notEatMenus;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + "\n");
            return takeNotEatMenus(coachName);
        }
    }
}
