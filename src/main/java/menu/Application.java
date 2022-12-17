package menu;

import menu.controller.Controller;
import menu.controller.InputController;
import menu.domain.CategoryRepository;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CategoryRepository.initCategories();
        OutputView.printStartMessage();
        Controller.run();

    }
}
