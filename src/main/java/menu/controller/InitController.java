package menu.controller;

import menu.domain.category.Category;
import menu.domain.category.CategoryRepository;
import menu.domain.category.CategoryType;
import menu.domain.menu.MenuRepository;

public class InitController {

    MenuRepository menuRepository;
    CategoryRepository categoryRepository;

    public InitController() {
        this.menuRepository = MenuRepository.getInstance();
        this.categoryRepository = CategoryRepository.getInstance();
    }

    public void run() {
        initCategoryAndMenuRepository();
    }

    private void initCategoryAndMenuRepository() {
        for (String categoryName : CategoryType.names) {
            int categoryId = CategoryType.getIndexByName(categoryName);
            Category category = new Category(categoryName);
            categoryRepository.save(categoryId, category);

            initMenuRepository(category);
        }
    }


    private void initMenuRepository(Category category) {
        String name = category.getName();
        for (String menuNames : CategoryType.getMenusByName(name)) {
            menuRepository.save(category, menuNames);
        }
    }
}
