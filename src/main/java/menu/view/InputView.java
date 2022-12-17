package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.util.Separator;
import menu.util.Validator;

import java.util.List;

public class InputView {

    private final Validator validator = new Validator();
    private final Separator separator = new Separator();

    public List<Coach> readCoaches() {
        String inputCoaches = Console.readLine();
        List<String> coachNames = separator.separateCoachNames(inputCoaches);
        validator.validateCoachCount(coachNames);
        List<Coach> coaches = validator.validateCoachNameLength(coachNames);

        return coaches;
    }
}
