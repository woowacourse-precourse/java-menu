package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import menu.Coach;
import menu.Service;
import menu.validator.Validate;

public class InputView {

    private static final String COACH_DIVIDE = ",";

    public static void insertCoach(Service service) {
        String input = Console.readLine();
        Arrays.stream(input.split(COACH_DIVIDE)).forEach(coachNameInput -> {
            Validate.coachName(coachNameInput);
            service.addCoach(new Coach(coachNameInput));
        });
    }
}
