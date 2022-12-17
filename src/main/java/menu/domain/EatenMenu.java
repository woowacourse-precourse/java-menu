package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class EatenMenu {
    private final List<String> eatenMenu = new ArrayList<>();

    public boolean isEaten(String menu) {
        return eatenMenu.contains(menu);
    }

    public void eat(String menu) {
        eatenMenu.add(menu);
    }
}
