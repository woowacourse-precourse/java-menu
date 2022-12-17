package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static menu.util.ErrorCode.NOT_VALID_COACH_NAME;

public class Coach {
    private static final int COACH_NAME_LENGTH_MIN = 2;
    private static final int COACH_NAME_LENGTH_MAX = 4;
    private final List<String> MenuOfDays = new ArrayList<>();
    private final String name;
    private List<String> unableToEatMenus;

    public Coach(String name) {
        validateCoachName(name);
        this.name = name;
    }

    public void validateCoachName(String input) {
        if (input.length() < COACH_NAME_LENGTH_MIN || input.length() > COACH_NAME_LENGTH_MAX) {
            throw NOT_VALID_COACH_NAME.throwError();
        }
    }

    public void setUnableToEatMenus(List<String> unableToEatMenus) {
        this.unableToEatMenus = unableToEatMenus;
    }

    public void addMenuOfDaysWith(List<String> menu) {
        String todayMenu;
        do {
            todayMenu = Randoms.shuffle(menu).get(0);
        } while (!isPossibleMenuToAdd(todayMenu));

        MenuOfDays.add(todayMenu);
    }

    //유효성 검사
    public boolean isPossibleMenuToAdd(String menu) {
        return isEatableMenu(menu) && isNotDuplicatedMenu(menu);
    }

    public boolean isEatableMenu(String menu) {
        return !unableToEatMenus.contains(menu); //못먹는 음식에 포함되어있지 않은지.
    }

    public boolean isNotDuplicatedMenu(String menu) {
        return !MenuOfDays.contains(menu); //이미 중복되지 않았는지.
    }

    //getter
    public String getName() {
        return name;
    }

    public List<String> getRecommendMenuOfDays() {
        List<String> recommendMenus = new ArrayList<>();
        recommendMenus.add(name);
        recommendMenus.addAll(MenuOfDays);

        return recommendMenus;
    }

}
