package menu;

import menu.domain.menu.MenuRecommendService;
import menu.domain.menu.MenuRepository;
import menu.ui.view.InputView;
import menu.ui.view.ResultView;

public class Application {
    public static void main(String[] args) {

        MenuRepository menuRepository = new MenuRepository();
        MenuRecommendService menuRecommendService = new MenuRecommendService(menuRepository);

        MenuRecommendController menuRecommendController = new MenuRecommendController(
                InputView.getInstance(), ResultView.getInstance(), menuRecommendService
        );


        menuRecommendController.init();
        menuRecommendController.run();
    }
}
