package menu.model;

import menu.constants.ExceptionMessage;
import menu.constants.Category;

import java.util.ArrayList;
import java.util.List;

public class HateMenu {
    private final List<String> hateMenus = new ArrayList<>();

    public HateMenu(List<String> hateMenus) {
        for (String hateMenu : hateMenus) {
            validateMenu(hateMenu);
            this.hateMenus.add(hateMenu);
        }
    }

    private void validateMenu(String menu) {
        if (isNull(menu)) {
            return;
        }
        if (!Category.isExistMenu(menu)) {
            ExceptionMessage.NOT_EXIST_MENU.throwException();
        }
    }

    private boolean isNull(String menu) {
        return menu.isEmpty();
    }

    public boolean isHateMenu(String menu) {
        return hateMenus.contains(menu);
    }
}
