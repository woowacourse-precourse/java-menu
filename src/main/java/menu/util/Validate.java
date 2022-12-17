package menu.util;

import menu.service.MenuService;

import java.util.List;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class Validate {
    private static final MenuService menuService = new MenuService();
    public static void validateCoachNames(List<String> coachNames) {
        validateNumberOfCoach(coachNames);
        validateLengthOfCoachName(coachNames);
    }

    private static void validateLengthOfCoachName(List<String> coachNames) {
        if (coachNames.stream().anyMatch(coachName -> coachNames.size() < Command.COACH_NAME_LENGTH_MIN.getData())) {
            throw new IllegalArgumentException(IllegalArgumentExceptionMessage.INPUT_COACH_NAME_LENGTH_MIN.getMessage());
        } else if (coachNames.stream().anyMatch(coachName -> coachNames.size() > Command.COACH_NAME_LENGTH_MAX.getData())) {
            throw new IllegalArgumentException(IllegalArgumentExceptionMessage.INPUT_COACH_NAME_LENGTH_MAX.getMessage());
        }
    }

    private static void validateNumberOfCoach(List<String> coachNames) {
        if (coachNames.size() < Command.NUMBER_OF_COACH_MIN.getData()) {
            throw new IllegalArgumentException(IllegalArgumentExceptionMessage.INPUT_COACH_LENGTH_MIN.getMessage());
        } else if(coachNames.size() > Command.NUMBER_OF_COACH_MAX.getData()) {
            throw new IllegalArgumentException(IllegalArgumentExceptionMessage.INPUT_COACH_LENGTH_MAX.getMessage());
        }
    }

    public static void validateHateMenu(List<String> hateMenus) {
        if(hateMenus.size() > 2) {
            throw new IllegalArgumentException(IllegalArgumentExceptionMessage.HATE_MENU_SIZE.getMessage());
        }
        for (String hateMenu : hateMenus) {
            menuService.findByName(hateMenu);
        }
    }
}
