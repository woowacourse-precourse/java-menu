package menu.di;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.CoachName;

public class MenuUseCaseImpl implements MenuUseCase {

    private static final String MENU_NOT_FOUND_MESSAGE = "없는 메뉴입니다";
    private final List<String> categories;
    private final Map<Category, List<String>> menus;

    public MenuUseCaseImpl(List<String> categories, Map<String, List<String>> menus) {
        this.categories = categories;
        this.menus = toMenus(menus);
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
    public RecommendResultDto recommend(List<String> names, List<List<String>> menus) {
        return null;
    }

}
