package menu.di;

import java.util.List;

public interface MenuUseCase {

    void validateNames(ValidateNameCommand validateNameCommand);

    void validateMenus(ValidateMenuCommand validateMenuCommand);

    MenusDto recommend(List<String> names, List<String> menus);
}
