package domain;

import java.util.Map;

public class MenuDuplicatedChecker {
    private final Map<Menu, Integer> menusCheck;

    public MenuDuplicatedChecker(Map<Menu, Integer> menusCheck) {
        this.menusCheck = menusCheck;
    }
}
