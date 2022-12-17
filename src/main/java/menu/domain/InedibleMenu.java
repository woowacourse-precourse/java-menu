package menu.domain;

import menu.constant.ExceptionConstants;
import menu.constant.MenuConstants;
import menu.util.Validator;

import java.util.List;

public class InedibleMenu {
    private final List<String> inedibleMenu;

    public InedibleMenu(String inedibleMenu) {
        List<String> splittedInedibleMenu = List.of(inedibleMenu.split(MenuConstants.INPUT_DELIMITER));
        validateInedibleMenu(splittedInedibleMenu);
        this.inedibleMenu = splittedInedibleMenu;
    }

    private void validateInedibleMenu(List<String> splittedInedibleMenu) {
        Validator.validateDuplication(splittedInedibleMenu);
        Validator.validateUpperBound(splittedInedibleMenu.size(),
                MenuConstants.MAXIMUM_NUMBER_OF_INEDIBLE_MENUS,
                ExceptionConstants.TOO_MANY_MENUS);
    }

    public boolean isEdible(String menu) {
        return !inedibleMenu.contains(menu);
    }
}
