package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Categories;
import domain.Coach;
import domain.CoachNames;
import domain.Coaches;
import domain.Menus;
import domain.SelectedCategories;

public class Service {
    public static final String CATEGORY = "카테고리";
    private final Coaches coaches = new Coaches();
    private boolean onInitializing = true;
    private SelectedCategories selectedCategories;

    public Service() {
    }

    public void saveCoachNames(String readCoachNames) {
        CoachNames coachNames = new CoachNames(readCoachNames);
        coachNames.getCoachNames().forEach(name -> coaches.addCoach(new Coach(name)));
    }

    public boolean isOnInitializing() {
        if (coaches.getCoaches().stream().allMatch(Coach::hasInedibleMenus)) {
            onInitializing = false;
        }
        return onInitializing;
    }

    public String getCoachName() {
        for (Coach coach : coaches.getCoaches()) {
            if (!coach.hasInedibleMenus()) {
                return coach.getName();
            }
        }
        return null;
    }

    public void saveInedibleMenu(String coachName, String readInedibleMenu) {
        coaches.getCoaches().forEach(coach -> {
            if (coach.getName().equals(coachName)) {
                coach.addInedibleMenu(readInedibleMenu);
            }
        });
    }

    public void chooseCategories() {
        selectedCategories = new SelectedCategories(Categories.generateCategories());
    }

    public void chooseMenus() {
        for (String category : selectedCategories.getSelectedCategories()) {
            getRecommendedMenu(getMenuOfCategory(category));
        }
    }

    private List<String> getMenuOfCategory(String category) {
        return Arrays.stream(Menus.values())
            .filter(menus -> menus.getCategory().equals(category))
            .collect(Collectors.toList())
            .get(0)
            .getMenus();
    }

    private void getRecommendedMenu(List<String> menuOfCategory) {
        coaches.getCoaches().forEach(coach -> recommend(coach, menuOfCategory));
    }

    private void recommend(Coach coach, List<String> menuOfCategory) {
        while (true) {
            String recommendedMenu = Randoms.shuffle(menuOfCategory).get(0);
            if (coach.getInedibleMenus().contains(recommendedMenu) || coach.getMenus().contains(recommendedMenu)) {
                continue;
            }
            coach.addMenu(recommendedMenu);
            break;
        }
    }

    public List<List<String>> getRecommendation() {
        List<List<String>> recommendation = new ArrayList<>();

        recommendation.add(makeCategories());

        coaches.getCoaches().forEach(coach -> {
            List<String> coachAndMenu = new ArrayList<>();
            coachAndMenu.add(coach.getName());
            coachAndMenu.addAll(coach.getMenus());
            recommendation.add(coachAndMenu);
        });
        return recommendation;
    }

    private List<String> makeCategories() {
        List<String> categories = new ArrayList<>();
        categories.add(CATEGORY);
        categories.addAll(selectedCategories.getSelectedCategories());
        return categories;
    }
}
