package menu.controller.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.message.ErrorMessage;

public class ExcludeMenuDto {
    private final String coachName;
    private final List<String> menus;

    public ExcludeMenuDto(final String coachName, final String allMenu) {
        this.coachName = coachName;
        validateMenu(allMenu);
        menus = Arrays.stream(allMenu.split(","))
                .collect(Collectors.toList());
    }

    private void validateMenu(final String allMenu) {
        if (!isValidMenuLength(allMenu)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_EXCLUDE_MENU_COUNT);
        }
    }

    private boolean isValidMenuLength(final String allMenu) {
        int count = (int) Arrays.stream(allMenu.split(","))
                .filter(menu -> !menu.equals(""))
                .count();
        return count <= 2;
    }
}
