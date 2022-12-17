package service;

import java.util.ArrayList;
import java.util.List;

import domain.Categories;
import domain.Coach;
import domain.CoachNames;

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
}
