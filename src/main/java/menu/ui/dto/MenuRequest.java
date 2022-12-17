package menu.ui.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.common.ErrorMessage;

public class MenuRequest {
    private static final String LIST_DIAMETER = ",";
    private final List<String> menus;

    private MenuRequest(List<String> menus) {
        this.menus = menus;
    }

    public static MenuRequest from(String userInput) {
        validate(userInput);
        List<String> menus = Arrays.stream(userInput.split(LIST_DIAMETER))
                .map(String::trim)
                .collect(Collectors.toList());
        return new MenuRequest(menus);
    }

    private static void validate(String userInput) {
        String[] menus = userInput.split(LIST_DIAMETER);
        validateSize(menus);
        validateDuplication(menus);
    }

    private static void validateSize(String[] menus) {
        if (menus.length > 2) {
            throw new IllegalArgumentException(ErrorMessage.AVOID_MENU_OVER_MAX_SIZE);
        }
    }

    private static void validateDuplication(String[] menus) {
        long distinctSize = Arrays.stream(menus)
                .map(String::trim)
                .distinct()
                .count();

        if (distinctSize != menus.length) {
            throw new IllegalArgumentException(ErrorMessage.MENU_NAME_DUPLICATED);
        }
    }

    public List<String> getMenus() {
        return menus;
    }
}
