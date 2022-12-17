package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.Service;
import menu.validator.Validate;

public class InputView {

    private static final String DIVIDE = ",";
    private static final String NULL = "";

    public static void insertCoach(Service service) {
        String input = Console.readLine();
        Arrays.stream(input.split(DIVIDE)).forEach(coachNameInput -> {
            Validate.coachName(coachNameInput);
            service.addCoach(new Coach(coachNameInput));
        });
    }

    public static void insertHateMenuBy(Service service, Coach coach) {
        String input = Console.readLine();
        if (input.equals(NULL)) {
            return;
        }
        Arrays.stream(input.split(DIVIDE)).forEach(hateMenuInput -> {
            Menu menu = service.getMenuByName(hateMenuInput);
            service.addHateMenuBy(coach, menu);
        });
    }
}
