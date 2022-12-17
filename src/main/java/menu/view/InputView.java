package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.util.Separator;
import menu.util.Validator;

import java.util.List;

public class InputView {

    private final Validator validator = new Validator();
    private final Separator separator = new Separator();

    public List<Coach> readCoaches() {
        // inputCoachNames로 리팩터링 필요
        String inputCoaches = Console.readLine();
        List<String> coachNames = separator.separateNames(inputCoaches);
        validator.validateCoachCount(coachNames);
        List<Coach> coaches = validator.validateCoachNameLength(coachNames);

        return coaches;
    }

    public List<Menu> readHateMenus() {
        String inputHateMenusNames = Console.readLine();
        List<String> menuNames = separator.separateNames(inputHateMenusNames);
        validator.validateHateMenuCount(menuNames);
        List<Menu> hateMenus = validator.validateIsMenuExist(menuNames);

        return hateMenus;
    }
}
