package menu.di;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.CoachName;
import menu.domain.Picker;

public class MenuUseCaseImpl implements MenuUseCase {

    private static final String MENU_NOT_FOUND_MESSAGE = "없는 메뉴입니다";
    private final Map<Category, List<String>> menus;
    private final Picker picker;

    public MenuUseCaseImpl(Map<String, List<String>> menus, Picker picker) {
        this.menus = toMenus(menus);
        this.picker = picker;
    }

    private Map<Category, List<String>> toMenus(Map<String, List<String>> input) {
        Map<Category, List<String>> menus = new HashMap<>();

        input.entrySet()
                .stream()
                .forEach(it -> menus.put(Category.from(it.getKey()), it.getValue()));
        return menus;
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
    public RecommendResultDto recommend(List<String> names, List<List<String>> notEatMenus) {

        return null;
    }

}
