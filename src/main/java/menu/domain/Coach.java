package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private final List<String> dislikeMenu = new ArrayList<>();
    private List<String> recomandedMenu;

    public Coach(String name) {
        this.name = name;
        this.recomandedMenu = new ArrayList<>();
    }

    public void addDislikeMenu(String[] dislike) {
        for (String menu : dislike) {
//            System.out.println(menu);
            dislikeMenu.add(menu);
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getRecomandedMenu() {
        return recomandedMenu;
    }

    public List<String> getDislikeMenu() {
        return dislikeMenu;
    }
}
