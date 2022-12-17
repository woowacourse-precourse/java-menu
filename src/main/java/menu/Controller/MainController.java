package menu.Controller;

import menu.Model.Coaches;
import menu.View.OutputView;


public class MainController {
    private final Coaches coaches;
    private final RecommendController recommend;
    private final InitController initController;

    public MainController() {
        coaches = new Coaches();
        recommend = new RecommendController(coaches);
        initController = new InitController(coaches);
    }

    public void run() {
        OutputView.printRecommendStart();
        initController.initCoaches();
        initController.initNotPreferMenus();
        recommend.recommendStart();
    }
}
