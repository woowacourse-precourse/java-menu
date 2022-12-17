package menu.controller.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExcludeMenuDto {
    private final String coachName;
    private final List<String> menus;

    public ExcludeMenuDto(final String coachName, final String allMenu) {
        this.coachName = coachName;
        menus = Arrays.stream(allMenu.split(","))
                .collect(Collectors.toList());
    }
}
