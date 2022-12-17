package menu;



public class Service {
	Category category = new Category();
	Menu menu = new Menu();
	TotelMenu totelMenu = new TotelMenu();

	public void menuMapping() {
		category.settingCategorys();
		menu.settingMenu();
		for (int index = 0; index < category.getCategoriesCount(); index++)
			totelMenu.settingTotelMenus(category.getCategory(index), menu.getMenus(index));
	}

}
