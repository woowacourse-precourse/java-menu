package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class UnavailableMenu {
    private final static String ERROR_SIZE = "[ERROR] 못 먹는 음식은 2개까지만 입력가능합니다.";

    private final List<String> unavailableMenu;

    public UnavailableMenu() {
        this.unavailableMenu = new ArrayList<>();
    }

    public void addMenu(String menu) {
        validateSize(unavailableMenu.size());
        unavailableMenu.add(menu);
    }

    private void validateSize(int size) {
        if(size >= 2) {
            throw new IllegalArgumentException(ERROR_SIZE);
        }
    }

    public boolean hasMenu(String menu) {
        return unavailableMenu.contains(menu);
    }
}
