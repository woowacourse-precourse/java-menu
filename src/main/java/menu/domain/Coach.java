package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {

    private final String name;

    private List<String> hateMenus;

    private List<String> completeMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getCompleteMenus() {
        return Collections.unmodifiableList(completeMenus);
    }

    public void addHateMenus(List<String> hatingMenus) {
        hateMenus = hatingMenus;
    }

    public void addCompleteMenu(String menu) {
        completeMenus.add(menu);
    }

    public boolean isOkayToCompleteMenu(String menu) {
        List<String> standard = new ArrayList<>();
        standard.addAll(hateMenus);
        standard.addAll(completeMenus);
        if (standard.contains(menu)) {
            return false;
        }
        return true;
    }
}
