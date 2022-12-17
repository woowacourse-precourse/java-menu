package menu.model;

import java.util.List;

public class MenuSuggester {
    private List<Coach> coaches;
    private List<List<String>> menus;

    public MenuSuggester() {
        MenuGenerator menuGenerator = new MenuGenerator();
        menus = menuGenerator.generate();
        System.out.println(menus);
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public void suggest() {

    }
}
