package menu.util;

import menu.service.MenuService;

import java.util.List;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class Validate {
    private static final MenuService menuService = new MenuService();
    public static void validateCoachNames(List<String> coachName) {
        if (coachName.size() < 2) {
            throw new IllegalArgumentException(IllegalArgumentExceptionMessage.INPUT_COACH_LENGTH.getMessage());
        }
    }

    public static void validateHateMenu(List<String> hateMenus) {
        for (String hateMenu : hateMenus) {
            menuService.findByName(hateMenu);
        }
    }
}
