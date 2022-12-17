package menu;

import menu.domain.menu.MenuService;
import menu.domain.menu.MenuRepository;
import menu.ui.view.InputView;
import menu.ui.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MenuRepository menuRepository = new MenuRepository();
        MenuService menuService = new MenuService(menuRepository);

        MenuRecommendController menuRecommendController = new MenuRecommendController(
                InputView.getInstance(), OutputView.getInstance(), menuService
        );

        menuRecommendController.init();
        menuRecommendController.run();
    }
}
