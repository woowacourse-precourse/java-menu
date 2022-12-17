package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> hateMenus;

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addHateMenus(List<String> hateMenus){
        this.hateMenus = new ArrayList<>(hateMenus);
    }
}
