package menu.domain;

import menu.constant.MenuConstants;
import menu.util.Validator;

import java.util.List;

public class Menu {
    private final List<String> coachNames;
    private List<Coach> coaches;

    public Menu(String coachNames) {
        List<String> splittedCoaches = List.of(coachNames.split(MenuConstants.DELIMITER));

        Validator.validateNumberOfCoaches(splittedCoaches.size());
        Validator.validateDuplication(splittedCoaches);
        splittedCoaches.stream()
                .map(String::length)
                .forEach(Validator::validateCoachNameLength);

        this.coachNames = splittedCoaches;
    }

    public List<String> getCoachNames() {
        return coachNames;
    }
}
