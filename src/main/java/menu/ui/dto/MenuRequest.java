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
        String[] coaches = userInput.split(LIST_DIAMETER);
        validateSize(coaches);
        validateDuplication(coaches);
    }

    private static void validateSize(String[] coaches) {
        if (coaches.length > 2) {
            throw new IllegalArgumentException(ErrorMessage.AVOID_MENU_OVER_MAX_SIZE);
        }
    }

    private static void validateDuplication(String[] coaches) {
        long distinctSize = Arrays.stream(coaches)
                .map(String::trim)
                .distinct()
                .count();

        if (distinctSize != coaches.length) {
            throw new IllegalArgumentException(ErrorMessage.MENU_NAME_DUPLICATED);
        }
    }

    public List<String> getMenus() {
        return menus;
    }
}
