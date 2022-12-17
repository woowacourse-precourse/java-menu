package menu.di;

import java.util.List;
import menu.domain.CrewName;

public class MenuUseCaseImpl implements MenuUseCase {

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
