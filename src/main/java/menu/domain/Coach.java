package menu.domain;

import static menu.domain.constant.MenuRule.MAXIMUM_COACH_NAME_LENGTH;
import static menu.domain.constant.MenuRule.MAXIMUM_INEDIBLE_FOOD_COUNT;
import static menu.domain.constant.MenuRule.MINIMUM_COACH_NAME_LENGTH;
import static menu.domain.constant.MenuRule.MINIMUM_INEDIBLE_FOOD_COUNT;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.domain.constant.Category;
import menu.domain.constant.Day;
import menu.domain.vo.CoachMenu;

public class Coach {
    private final String name;
    private final List<String> inedibleFoods;
    private final Map<Day, String> weeklyFoods;

    public Coach(String name) {
        validate(name);
        this.name = name;
        this.inedibleFoods = new ArrayList<>();
        this.weeklyFoods = new LinkedHashMap<>();
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

    public void registerInedibleFoods(List<String> inedibleFoods) {
        validateInedibleFoods(inedibleFoods);
        this.inedibleFoods.addAll(inedibleFoods);
    }

    private void validateInedibleFoods(List<String> inedibleFoods) {
        if (MINIMUM_INEDIBLE_FOOD_COUNT <= inedibleFoods.size()
                && inedibleFoods.size() <= MAXIMUM_INEDIBLE_FOOD_COUNT) {
            return;
        }
        throw new IllegalArgumentException(String.format(
                "[ERROR] 못 먹는 메뉴는 코치 당 %d개 이상 %d개 이하여야 합니다.",
                MINIMUM_INEDIBLE_FOOD_COUNT,
                MAXIMUM_INEDIBLE_FOOD_COUNT
        ));
    }

    public void recommendMenuOfDay(Day day, Category categoryOfDay) {
        String recommendMenu;
        do {
            recommendMenu = categoryOfDay.getRandomMenu();
        } while (!canAddMenu(recommendMenu));
        weeklyFoods.put(day, recommendMenu);
    }

    private boolean canAddMenu(String menu) {
        if (inedibleFoods.contains(menu)) {
            return false;
        }
        List<String> existFoods = new ArrayList<>(weeklyFoods.values());
        if (existFoods.contains(menu)) {
            return false;
        }
        return true;
    }

    public CoachMenu getCoachMenu() {
        List<String> existFoods = new ArrayList<>(weeklyFoods.values());
        System.out.println(weeklyFoods.keySet());
        System.out.println(weeklyFoods.values());
        return new CoachMenu(name, existFoods);
    }
}
