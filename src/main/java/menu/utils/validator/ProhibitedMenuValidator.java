package menu.utils.validator;

import static menu.utils.Constants.ERROR_PROHIBITED_MENU_NUMBER;

import java.util.List;

public class ProhibitedMenuValidator {

    private final List<String> prohibitedMenus;

    public ProhibitedMenuValidator(List<String> prohibitedMenus) {
        this.prohibitedMenus = prohibitedMenus;
        prohibitedMenuNumberValidator(prohibitedMenus);
    }

    private void prohibitedMenuNumberValidator(List<String> prohibitedMenus) {
        if (prohibitedMenus.size() > 2){
            throw new IllegalArgumentException(ERROR_PROHIBITED_MENU_NUMBER);
        }
    }
}
