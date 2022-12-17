package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Categories;
import domain.Coach;
import domain.CoachNames;
import domain.Menus;

public class Service {
    private CoachNames coachNames;
    private List<Coach> coaches = new ArrayList<>();
    private boolean onInitializing = true;
    private List<String> categories;

    public void saveCoachNames(String readCoachNames) {
        coachNames = new CoachNames(readCoachNames);
        coachNames.getCoachNames().forEach(name -> coaches.add(new Coach(name)));
    }

    public boolean isOnInitializing() {
        if (coaches.stream().allMatch(Coach::hasInedibleMenus)) {
            onInitializing = false;
        }
        return onInitializing;
    }

    public String getCoachName() {
        for (Coach coach : coaches) {
            if (!coach.hasInedibleMenus()) {
                return coach.getName();
            }
        }
        return null;
    }

    public void saveInedibleMenu(String coachName, String readInedibleMenu) {
        coaches.forEach(coach -> {
            if (coach.getName().equals(coachName)) {
                coach.addInedibleMenu(readInedibleMenu);
            }
        });
    }

    public void chooseCategories() {
        categories = Categories.generateCategories();
    }

    public void chooseMenus() {
        for (String category : categories) {
            List<String> menu = Arrays.stream(Menus.values())
                .filter(menus -> menus.getCategory().equals(category))
                .collect(Collectors.toList())
                .get(0)
                .getMenus();
            coaches.forEach(coach -> {
                while (true) {
                    String recommendedMenu = Randoms.shuffle(menu).get(0);
                    if (coach.getInedibleMenus().contains(recommendedMenu) && coach.getMenus().contains(recommendedMenu)) {
                        continue;
                    }
                    coach.addMenu(recommendedMenu);
                    break;
                }
            });
        }
    }

    public List<List<String>> getRecommendation() {
        List<List<String>> recommendation = new ArrayList<>();
        categories.add(0, "카테고리");
        recommendation.add(categories);
        coaches.forEach(coach -> {
            List<String> coachAndMenu = new ArrayList<>();
            coachAndMenu.add(coach.getName());
            coachAndMenu.addAll(coach.getMenus());
            recommendation.add(coachAndMenu);
        });
        return recommendation;
    }
}
