package menu.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.format.ErrorFormat;

public class Validator {

    public static List<String> validateCouches(List<String> couchNames) {
        if (couchNames.size() < 2 || couchNames.size() > 5) {
            throw new IllegalArgumentException(ErrorFormat.INVALID_COUCH_COUNTS.getMessage());
        }

        if (new HashSet<>(couchNames).size() != couchNames.size()) {
            throw new IllegalArgumentException(ErrorFormat.DUPLICATED_NAME.getMessage());
        }

        if (couchNames.stream().anyMatch((name) -> name.length() < 2 || name.length() > 4)) {
            throw new IllegalArgumentException(ErrorFormat.INVALID_COUCH_NAME.getMessage());
        }
        return couchNames;
    }

    public static List<String> validateMenus(List<String> menuNames) {
        if (menuNames.size() > 2) {
            throw new IllegalArgumentException(ErrorFormat.INVALID_COUNT_OF_MENU.getMessage());
        }

        if (new HashSet<>(menuNames).size() != menuNames.size()) {
            throw new IllegalArgumentException(ErrorFormat.DUPLICATED_NAME.getMessage());
        }

        if (menuNames.size() != 0) {
            menuNames.forEach((menuName) -> MenuRepository.getMenusByName(menuName));
        }
        return menuNames;
    }
}
