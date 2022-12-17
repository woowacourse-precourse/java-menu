package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Validation;

public class InputView {

    private final Validation validation;

    public InputView() {
        this.validation = new Validation();
    }

    public String[] readCoachName() {
        String[] coachNames = Console.readLine().split(",");

        try{
            validation.validateNumberOfCoaches(coachNames);
            validation.validateNameSize(coachNames);
            return coachNames;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCoachName();
        }
    }
}
