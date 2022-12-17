package menu.domain;

import menu.constant.MenuConstants;
import menu.util.Validator;

import java.util.List;

public class InedibleMenu {
    private final List<String> inedibleMenu;

    public InedibleMenu(String inedibleMenu) {
        List<String> splittedInedibleMenu = List.of(inedibleMenu.split(MenuConstants.INPUT_DELIMITER));
        Validator.validateDuplication(splittedInedibleMenu);
        Validator.validateNumberOfInedibleMenus(splittedInedibleMenu.size());
        this.inedibleMenu = splittedInedibleMenu;
    }

    public boolean isEdible(String menu) {
        return !inedibleMenu.contains(menu);
    }
}
