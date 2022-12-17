package menu.service;

import menu.domain.*;
import menu.domain.WeeklyMenus;
import menu.repository.CoachRepository;
import menu.repository.MenuRepository;
import menu.repository.WeeklyMenuRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecommendService {
    private WeeklyMenuRepository weeklyMenuRepository = new WeeklyMenuRepository();
    private CoachRepository coachRepository = new CoachRepository();
    private MenuRepository menuRepository = new MenuRepository();

    public void createWeeklyRecommendMenu() {
        Arrays.stream(Day.values())
                .forEach(day -> {
                    WeeklyMenu weeklyMenu = recommendMenu(day);
                    weeklyMenuRepository.saveWeeklyMenu(day, weeklyMenu);
                });
    }

    public WeeklyMenus getWeeklyMenus() {
        WeeklyMenus weeklyMenus = new WeeklyMenus(coachRepository.getCoaches());
        Arrays.stream(Day.values())
                .forEach(day -> {
                    WeeklyMenu weeklyMenu = weeklyMenuRepository.findByDay(day);
                    weeklyMenus.addWeeklyMenu(day, weeklyMenu);
                });
        return weeklyMenus;
    }

    private WeeklyMenu recommendMenu(Day day) {
        Category category = getValidCategory();
        List<Coach> coaches = coachRepository.getCoaches();
        Menus menus = menuRepository.findByCategory(category);
        List<CoachMenu> coachesMenu = new ArrayList<>();
        coaches.stream().forEach(coach -> {
            coachesMenu.add(getValidCoachMenu(coach, menus));
        });
        return WeeklyMenu.from(category, coachesMenu);
    }

    private Category getValidCategory() {
        while (true) {
            Category randomCategory = Category.getRandomCategory();
            if (weeklyMenuRepository.isValidCategory(randomCategory)) {
                return randomCategory;
            }
        }
    }

    private CoachMenu getValidCoachMenu(Coach coach, Menus menus) {
        while (true) {
            String menu = menus.getRandomMenu();
            if (validCanEatMenu(coach, menu) && validDuplicateMenu(coach, menu)) {
                return CoachMenu.from(coach, menu);
            }
        }
    }

    private boolean validDuplicateMenu(Coach coach, String menu) {
        if (weeklyMenuRepository.isDuplicatedCoachMenu(CoachMenu.from(coach, menu))) {
            return false;
        }
        return true;
    }

    private boolean validCanEatMenu(Coach coach, String menu) {
        return coach.canEat(menu);
    }
}