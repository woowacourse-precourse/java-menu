package menu.service;

import menu.exception.CoachValidator;
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
}
