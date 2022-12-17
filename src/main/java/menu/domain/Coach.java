package menu.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Coach {
    private final String name;
    private List<String> hateMenu;
    private List<String> eatenMenu;

    public Coach(String name) {
        this.name = name;
        hateMenu = new ArrayList<>();
        eatenMenu = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setHateMenu(List<String> hateMenu) {
        this.hateMenu = hateMenu;
    }
    public void addEatenMenu(String menu){
        eatenMenu.add(menu);
    }

    public List<String> getHateMenu() {
        return hateMenu;
    }

    public List<String> getEatenMenu() {
        return eatenMenu;
    }
}
