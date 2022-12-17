package menu.domain;

import java.util.HashMap;
import java.util.List;

public class NoEatMenu {
    private HashMap<Coach, List<String>> noEatMenu = new HashMap<>();

    public NoEatMenu(HashMap<Coach, List<String>> noEatMenuHash) {
        this.noEatMenu = noEatMenuHash;
    }
}
