package menu.di;

import java.util.List;
import java.util.Map;
import menu.domain.CoachName;

public class MenuUseCaseImpl implements MenuUseCase {

    private static final String MENU_NOT_FOUND_MESSAGE = "없는 메뉴입니다";
    private final List<String> categories;
    private final Map<String, List<String>> menus;

    public MenuUseCaseImpl(List<String> categories, Map<String, List<String>> menus) {
        this.categories = categories;
        this.menus = menus;
    }

    @Override
    public void validateNames(ValidateNameCommand validateNameCommand) {
        List<String> names = validateNameCommand.getNames();
        names.forEach(CoachName::new);
    }

    @Override
    public void validateMenus(ValidateMenuCommand validateMenuCommand) {
        validateMenuCommand.getMenus()
                .forEach(this::validateMenu);
    }

    private void validateMenu(String menu) {
        boolean menuIsValid = menus.values().stream().anyMatch(it -> it.contains(menu));
        if (!menuIsValid) {
            throw new IllegalArgumentException(MENU_NOT_FOUND_MESSAGE);
        }
    }

    @Override
    public MenusDto recommend(List<String> names, List<String> menus) {
        return null;
    }

}
