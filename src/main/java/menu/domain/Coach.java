package menu.domain;

import menu.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<Menu> ateMenu; // 네이밍 이상
    private List<String> hateMenuNames;

    public Coach(String name) {
        Validator.validateCoachNameLength(name);
        this.name = name;
        this.ateMenu = new ArrayList<>();
        this.hateMenuNames = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setAteMenu(List<Menu> ateMenu) {
        this.ateMenu = ateMenu;
    }

    public void setHateMenu(List<String> hateMenuNames) {
        // 검증 로직 필요
        this.hateMenuNames = hateMenuNames;
    }

}

