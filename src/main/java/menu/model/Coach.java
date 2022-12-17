package menu.model;

import menu.module.NotModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coach extends NotModule {

    private final String name;
    private final List<String> hateFoods;
    private List<String> choicedMenus;

    public Coach(String name, List<String> hateFoods) {
        this.name = name;
        this.hateFoods = hateFoods;
        this.choicedMenus = new ArrayList<>();
        CoachRepository.addCoach(this);
    }

    public String getName() {
        return this.name;
    }

    public List<String> getHateFoods() {
        return this.hateFoods;
    }

    public List<String> getChoicedMenus() {
        return this.choicedMenus;
    }

    public void addMenu(String menu) {
        if (canAddMenu(menu)) {
            choicedMenus.add(menu);
        }
    }

    public boolean canAddMenu(String menu) {
        return not(choicedMenus.stream()
                .anyMatch(choicedMenu -> Objects.equals(choicedMenu, menu))
                ||
                hateFoods.contains(menu));
    }
}