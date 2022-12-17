package menu.domain;

import menu.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<Menu> ateMenu; // 네이밍 이상
    private List<Menu> hateMenu;

    public Coach(String name){
        Validator.validateCoachNameLength(name);
        this.name = name;
        this.ateMenu = new ArrayList<>();
        this.hateMenu = new ArrayList<>();
    }

    public void setAteMenu(List<Menu> ateMenu) {
        this.ateMenu = ateMenu;
    }

    public void setHateMenu(List<Menu> hateMenu) {
        this.hateMenu = hateMenu;
    }
}
