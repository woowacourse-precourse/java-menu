package menu.domain;

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
        this.name = name;
        this.inedibleFoods = new ArrayList<>();
        this.weeklyFoods = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public boolean isNameOf(String name) {
        return this.name.equals(name);
    }

    public void registerInedibleFoods(List<String> inedibleFoods) {
        this.inedibleFoods.addAll(inedibleFoods);
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
