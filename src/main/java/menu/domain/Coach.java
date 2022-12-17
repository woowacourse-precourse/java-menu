package menu.domain;

import java.util.List;

public class Coach {
    private String name;
    private List<String> dislikeMenu;

    public Coach(String name) {
        this.name = name;
    }

    public void addDislikeMenu(List<String> dislike) {
        for (String menu : dislike) {
            dislikeMenu.add(menu);
        }
    }

}
