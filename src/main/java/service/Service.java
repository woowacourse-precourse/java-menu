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
    private List<Coach> coachs = new ArrayList<>();
    private boolean onInitializing = true;
    private List<String> categories;

    public void saveCoachNames(String readCoachNames) {
        coachNames = new CoachNames(readCoachNames);
        coachNames.getCoachNames().forEach(name -> coachs.add(new Coach(name)));
    }

    public boolean isOnInitializing() {
        if (coachs.stream().allMatch(Coach::hasInedibleMenus)) {
            onInitializing = false;
        }
        return onInitializing;
    }

    public String getCoachName() {
        for (Coach coach : coachs) {
            if (!coach.hasInedibleMenus()) {
                return coach.getName();
            }
        }
        return null;
    }

    public void saveInedibleMenu(String coachName, String readInedibleMenu) {
        coachs.forEach(coach -> {
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
            coachs.forEach(coach -> {
                while (true) {
                    String recommendedMenu = Randoms.shuffle(menu).get(0);
                    if (coach.getInedibleMenus().contains(recommendedMenu)) {
                        continue;
                    }
                    coach.addMenu(recommendedMenu);
                    break;
                }
            });
        }
        coachs.forEach(coach -> coach.getMenus().forEach(System.out::println));
    }
}
