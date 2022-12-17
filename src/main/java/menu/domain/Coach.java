package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.utils.validator.CoachValidator;

public class Coach {

    private final String name;
    private List<String> prohibitedMenus;
    private List<String> doneMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
        new CoachValidator(name);
    }

    public void addProhibitedMenus(List<String> prohibitedMenus){
        this.prohibitedMenus = prohibitedMenus;
    }

    public void addDoneMenus(String menu){
        this.doneMenus.add(menu);
    }

    public String getName() {
        return name;
    }

    public List<String> getProhibitedMenus() {
        return prohibitedMenus;
    }

    public List<String> getDoneMenus() {
        return doneMenus;
    }
}
