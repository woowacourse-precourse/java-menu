package domain;

import java.util.HashMap;
import java.util.Map;

public class MenuDuplicatedChecker {
    private final Map<Menu, Integer> menusCheck;

    public MenuDuplicatedChecker() {
        menusCheck = new HashMap<>();

    }

    public void increaseMenuCount(Menu menu) {
        menusCheck.merge(menu, 1, (oldValue, newValue) -> oldValue + 1);
    }

    public boolean isDuplicated(Menu menu) {
        try {
            if (menusCheck.get(menu) >= 1) {
                return true;
            }
        } catch(NullPointerException e) {
            menusCheck.put(menu, 0);
        }

        return false;

    }

    public void clear() {
        menusCheck.clear();
    }
}
