package menu.domains;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    String name;
    List<String> cannotEatMenus;
    List<String> suggestedMenus;

    public Coach(String name) {
        this.name = name;
        this.cannotEatMenus = new ArrayList<>();
        this.suggestedMenus = new ArrayList<>();
    }
}
