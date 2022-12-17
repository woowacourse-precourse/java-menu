package menu.domain;

import menu.constant.MenuConstants;
import menu.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<String> coachNames;
    private final List<Coach> coaches = new ArrayList<>();

    public Menu(String coachNames) {
        List<String> splittedCoaches = List.of(coachNames.split(MenuConstants.DELIMITER));

        Validator.validateNumberOfCoaches(splittedCoaches.size());
        Validator.validateDuplication(splittedCoaches);
        splittedCoaches.stream()
                .map(String::length)
                .forEach(Validator::validateCoachNameLength);

        this.coachNames = splittedCoaches;
    }

    public void addCoach(String name, String inedibleMenu) {
        coaches.add(new Coach(name, inedibleMenu));
    }

    public List<String> getCoachNames() {
        return coachNames;
    }
}
