package menu.di;

import java.util.List;
import java.util.Map;
import menu.domain.CrewName;

public class MenuUseCaseImpl implements MenuUseCase {

    private final List<String> categories;
    private final Map<String, List<String>> menus;

    public MenuUseCaseImpl(List<String> categories, Map<String, List<String>> menus) {
        this.categories = categories;
        this.menus = menus;
    }

    @Override
    public void validateNames(ValidateNameCommand validateNameCommand) {
        List<String> names = validateNameCommand.getNames();
        names.forEach(CrewName::new);
    }

    @Override
    public void validateMenus(ValidateMenuCommand validateMenuCommand) {

    }

    @Override
    public MenusDto recommend(List<String> names, List<String> menus) {
        return null;
    }

}
