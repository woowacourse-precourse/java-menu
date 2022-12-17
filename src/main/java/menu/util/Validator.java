package menu.util;

import menu.domain.Coach;
import menu.domain.Menu;

import java.util.ArrayList;
import java.util.List;

import static menu.util.Constants.ERROR_PREFIX;

public class Validator {

    public void validateCoachCount(List<String> inputCoaches) {
        if(inputCoaches.size() < 2 || inputCoaches.size() > 5) {
            throw new IllegalArgumentException(ERROR_PREFIX + "코치는 최소 2명, 최대 5명 식사를 같이 할 수 있습니다.");
        }
    }

    public List<Coach> validateCoachNameLength(List<String> inputCoaches) {
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : inputCoaches) {
            if(coachName.length() < 2 || coachName.length() > 4) {
                throw new IllegalArgumentException(ERROR_PREFIX + "코치의 이름은 2글자 이상, 4글자 이하여야 합니다.");
            }
            coaches.add(new Coach(coachName));
        }

        return coaches;
    }

    public void validateHateMenuCount(List<String> inputMenuNames) {
        if(inputMenuNames.size() < -1 || inputMenuNames.size() > 2) {
            throw new IllegalArgumentException(ERROR_PREFIX + "코치는 최소 2명, 최대 5명 식사를 같이 할 수 있습니다.");
        }
    }

    public List<Menu> validateIsMenuExist(List<String> inputMenuNames) {
        List<Menu> hateMenus = new ArrayList<>();
        for (String inputMenuName : inputMenuNames) {
            Menu menu = Menu.checkIsMenuExist(inputMenuName);
            hateMenus.add(menu);
        }

        return hateMenus;
    }
}
