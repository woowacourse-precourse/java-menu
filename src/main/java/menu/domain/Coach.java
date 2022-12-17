package menu.domain;

import static menu.domain.constant.MenuRule.MAXIMUM_COACH_NAME_LENGTH;
import static menu.domain.constant.MenuRule.MAXIMUM_INEDIBLE_MENU_COUNT;
import static menu.domain.constant.MenuRule.MINIMUM_COACH_NAME_LENGTH;
import static menu.domain.constant.MenuRule.MINIMUM_INEDIBLE_MENU_COUNT;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.domain.constant.Category;
import menu.domain.constant.Day;
import menu.domain.vo.CoachMenu;

public class Coach {
    private final String name;
    private final List<String> inedibleMenus;
    private final Map<Day, String> weeklyMenus;

    public Coach(String name) {
        validate(name);
        this.name = name;
        this.inedibleMenus = new ArrayList<>();
        this.weeklyMenus = new LinkedHashMap<>();
    }

    private void validate(String name) {
        if (MINIMUM_COACH_NAME_LENGTH <= name.length() && name.length() <= MAXIMUM_COACH_NAME_LENGTH) {
            return;
        }
        throw new IllegalArgumentException(String.format(
                "[ERROR] 코치 이름은 %d자 이상 %d자 이하여야 합니다.", MINIMUM_COACH_NAME_LENGTH, MAXIMUM_COACH_NAME_LENGTH
        ));
    }

    public String getName() {
        return name;
    }

    public boolean isNameOf(String name) {
        return this.name.equals(name);
    }

    public void registerInedibleMenus(List<String> inedibleMenus) {
        validateInedibleMenus(inedibleMenus);
        this.inedibleMenus.addAll(inedibleMenus);
    }

    private void validateInedibleMenus(List<String> inedibleMenus) {
        if (MINIMUM_INEDIBLE_MENU_COUNT <= inedibleMenus.size()
                && inedibleMenus.size() <= MAXIMUM_INEDIBLE_MENU_COUNT) {
            return;
        }
        throw new IllegalArgumentException(String.format(
                "[ERROR] 못 먹는 메뉴는 코치 당 %d개 이상 %d개 이하여야 합니다.",
                MINIMUM_INEDIBLE_MENU_COUNT,
                MAXIMUM_INEDIBLE_MENU_COUNT
        ));
    }

    public void recommendMenuOfDay(Day day, Category categoryOfDay) {
        String recommendMenu;
        do {
            recommendMenu = categoryOfDay.getRandomMenu();
        } while (!canAddMenu(recommendMenu));
        weeklyMenus.put(day, recommendMenu);
    }

    private boolean canAddMenu(String menu) {
        if (inedibleMenus.contains(menu)) {
            return false;
        }
        List<String> existMenus = new ArrayList<>(weeklyMenus.values());
        if (existMenus.contains(menu)) {
            return false;
        }
        return true;
    }

    public CoachMenu getCoachMenu() {
        List<String> existMenus = new ArrayList<>(weeklyMenus.values());
        return new CoachMenu(name, existMenus);
    }
}
