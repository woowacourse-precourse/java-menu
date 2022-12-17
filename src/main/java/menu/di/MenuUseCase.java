package menu.di;

import java.util.List;

public interface MenuUseCase {

    void validateNames(ValidateNameCommand validateNameCommand);

    void validateMenus(ValidateMenuCommand validateMenuCommand);

    RecommendResultDto recommend(List<String> names, List<List<String>> menus);
}
