package menu.utls;

import menu.message.ErrorMessage;
import menu.model.Category;
import java.util.Arrays;
import java.util.HashSet;

public class Validator {
    private static final String DELIMITER = ",";
    private static final String SPACE = " ";
    private static final int COACH_MIN_LENGTH = 2;
    private static final int COACH_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENGTH = 4;
    private static final int ALLEGE_MENU_MAX_LENGTH = 2;

    public void validateCoachNames(String input) {
        String[] names = input.split(DELIMITER);
        int length = names.length;
        checkCoachLength(length);
        checkNameLength(names);
        checkDuplicateName(names);
    }

    private void checkDuplicateName(String[] names) {
        for (int index = 0; index < names.length; index++) {
            check(names, index);
        }
    }

    private void check(String[] names, int index) {
        String name = names[index];
        for (int compareIndex = 0; compareIndex < names.length; compareIndex++) {
            if (index == compareIndex) {
                continue;
            }
            if (name.equals(names[compareIndex])) {
                throw new IllegalArgumentException(ErrorMessage.INCORRECT_COACH_NAMES);
            }
        }
    }

    private void checkNameLength(String[] names) {
        for (String name : names) {
            if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.INCORRECT_COACH_NAMES);
            }
        }
    }

    private void checkCoachLength(int length) {
        if (length < COACH_MIN_LENGTH || length > COACH_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_COACH_NAMES);
        }
    }

    public void validateAllegeMenu(String input) {
        String[] allegeMenu = input.split(DELIMITER);
        if (allegeMenu.length > ALLEGE_MENU_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_ALLEGE_MENU);
        }
        HashSet<String> exist = initExist(Category.values());
        checkAllegeMenu(allegeMenu, exist);
    }

    private void checkAllegeMenu(String[] allegeMenu, HashSet<String> exist) {
        for (String menu : allegeMenu) {
            System.out.println(!exist.contains(menu));
            if (!exist.contains(menu)) {
                throw new IllegalArgumentException(ErrorMessage.INCORRECT_ALLEGE_MENU);
            }
        }
    }

    private HashSet<String> initExist(Category[] categories) {
        HashSet<String> exist = new HashSet<>();
        for (Category category : categories) {
            String[] menus = category.getMenus().split(DELIMITER + SPACE);
            exist.addAll(Arrays.asList(menus));
        }
        return exist;
    }
}
