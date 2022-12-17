package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> eatenMenu;
    private List<String> hateMenu;


    public Coach(String name) {
        this.name = name;
        eatenMenu = new ArrayList<>();
        hateMenu = new ArrayList<>();
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
