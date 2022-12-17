package menu.domain;

import menu.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<Menu> ateMenus; // 네이밍 이상
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

    public void updateAteMenus(Menu ateMenu) {
        this.ateMenus.add(ateMenu);
    }

    public void setHateMenuNames(List<String> hateMenuNames) {
        // 검증 로직 필요
        this.hateMenuNames = hateMenuNames;
    }

    public boolean canEat(Menu menu){
        return !ateMenus.contains(menu) && !hateMenuNames.contains(menu.getName());
    }

}

