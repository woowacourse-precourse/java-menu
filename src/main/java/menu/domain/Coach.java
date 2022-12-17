package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final UnavailableMenu unavailableMenu;
    private final RecommendMenu recommendMenu;

    private Coach(String name) {
        this.name = name;
        this.recommendMenu = new RecommendMenu();
        this.unavailableMenu = new UnavailableMenu();
    }

    public static Coach createCoach(String name) {
        return new Coach(name);
    }

    
}
