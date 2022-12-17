package menu.di;

public interface MenuUseCase {

    void validateNames(ValidateNameCommand validateNameCommand);

    void validateMenus(ValidateMenuCommand validateMenuCommand);

    MenusDto recommend(ValidateNameCommand nameCommand, ValidateMenuCommand menuCommand);
}
