package menu;

import menu.domain.food.CategoryFactory;

public class Application {
    public static void main(String[] args) {
        CategoryFactory.makeFood();
        CategoryView categoryView = new CategoryView();
        categoryView.run();
    }
}
