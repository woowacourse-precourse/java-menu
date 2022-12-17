package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import util.Validator;

public class Coach {
    private static final String COMMA = ",";
    private final String name;
    private final List<String> menus = new ArrayList<>();
    private List<String> inedibleMenus = null;

    public Coach(String name) {
        this.name = name;
    }

    public void addInedibleMenu(String inedibleMenu) {
        List<String> menuCandidate = Arrays.stream(inedibleMenu.split(COMMA)).collect(Collectors.toList());
        Validator.validateMenus(menuCandidate);
        inedibleMenus = menuCandidate;
    }

    public List<String> getInedibleMenus() {
        return inedibleMenus;
    }

    public String getName() {
        return name;
    }

    public boolean hasInedibleMenus() {
        return inedibleMenus != null;
    }

    public void addMenu(String menu) {
        menus.add(menu);
    }

    public List<String> getMenus() {
        return menus;
    }
}
