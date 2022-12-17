package menu;

import menu.controller.Controller;
import menu.controller.InputController;
import menu.domain.CategoryRepository;

public class Application {
    public static void main(String[] args) {


        CategoryRepository.initCategories();
        Controller.run();

    }
}
