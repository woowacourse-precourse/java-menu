package menu.domain;

import menu.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Coach {
    private final String name;
    private List<String> ateMenus; // 네이밍 이상
    private List<String> hateMenuNames;

    public Coach(String name) {
        Validator.validateCoachNameLength(name);
        this.name = name;
        this.ateMenus = new ArrayList<>();
        this.hateMenuNames = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void updateAteMenus(String ateMenu) {
        this.ateMenus.add(ateMenu);
    }

    public void setHateMenuNames(List<String> hateMenuNames) {
        this.hateMenuNames = hateMenuNames;
    }

    public boolean canEat(String menu) {
        return !ateMenus.contains(menu) && !hateMenuNames.contains(menu);
    }

    public List<String> getAteMenuNames() {
        return ateMenus;
    }

}

