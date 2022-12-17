package menu;

import java.util.List;

public class Validator {

    public static List<String> validateCouches(List<String> couchNames) {
        if (couchNames.size() < 2) {
            throw new IllegalArgumentException(ErrorFormat.NEED_MORE_COUCH.getMessage());
        }
        return couchNames;
    }

    public static List<String> validateMenus(List<String> menuNames) {
        try {
            menuNames.forEach((menuName) -> MenuRepository.getMenusByName(menuName));
            return menuNames;
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorFormat.INVALID_MENU_NAME.getMessage());
        }
    }
}
