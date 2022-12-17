package menu.view;

import menu.domain.Category;

import java.util.List;

public class InputValidator {

    private static final int MINIMUM_COACH_NAME_LENGTH = 2;
    private static final int MAXIMUM_COACH_NAME_LENGTH = 4;
    private static final int MINIMUM_NUMBER_OF_COACH = 2;
    private static final int MAXIMUM_NUMBER_OF_COACH = 5;
    private static final int MAXIMUM_NUMBER_OF_CAN_NOT_EAT_MENU = 2;
    private static final String INVALID_COACH_NAME_LENGTH_MESSAGE = "코치 이름은 2글자 이상 4글자 이하입니다.";
    private static final String INVALID_NUMBER_OF_COACH_MESSAGE = "코치는 2명 이상 5명 이하입니다.";
    private static final String INVALID_NUMBER_OF_CAN_NOT_EAT_MENU = "못 먹는 메뉴는 2개까지만 가능합니다.";
    private static final String INVALID_MENU_NAME_MESSAGE = "카테고리에 존재하지 않는 메뉴입니다.";

    public void validateCoachName(String coachName) {
        if (coachName.length() < MINIMUM_COACH_NAME_LENGTH || coachName.length() > MAXIMUM_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_COACH_NAME_LENGTH_MESSAGE);
        }
    }

    public void validateCoachNamesLength(List<String> coachNames) {
        if (coachNames.size() < MINIMUM_NUMBER_OF_COACH || coachNames.size() > MAXIMUM_NUMBER_OF_COACH) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_COACH_MESSAGE);
        }
    }

    public void validateCanNotEatMenusLength(List<String> canNotEatMenus) {
        if (canNotEatMenus.size() > MAXIMUM_NUMBER_OF_CAN_NOT_EAT_MENU) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_CAN_NOT_EAT_MENU);
        }
    }

    public void validateCanNotEatMenu(String menuName) {
        boolean contain = false;
        for (Category category : Category.values()) {
            List<String> menus = category.getMenu();
            if (menus.contains(menuName)) {
                contain = true;
                break;
            }
        }

        if (!contain) {
            throw new IllegalArgumentException(INVALID_MENU_NAME_MESSAGE);
        }
    }

}
