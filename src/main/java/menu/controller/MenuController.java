package menu.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.controller.util.ExceptionHandler;
import menu.model.MenuRecommender;
import menu.model.domain.Coaches;
import menu.model.domain.DislikeMenus;
import menu.view.MenuView;

public class MenuController {
    private final MenuView menuView = new MenuView();
    private MenuRecommender menuRecommender;
    private Coaches coaches;

    public void run() {
        menuView.printInformStart();
        ExceptionHandler.retryForIllegalArgument(this::askCoachNames, menuView::printError);
        ExceptionHandler.retryForIllegalArgument(this::askDislikeMenus, menuView::printError);
        recommend(coaches);
    }

    private void askCoachNames() {
        List<String> coachNames = menuView.inputCoachNames();
        coaches = new Coaches(coachNames);
    }

    private void askDislikeMenus() {
        List<List<String>> dislikeMenusByCoach = menuView.inputDisLikeMenus(coaches.getNames());
        List<DislikeMenus> dislikeMenus = dislikeMenusByCoach.stream()
                .map(DislikeMenus::new)
                .collect(Collectors.toList());
        coaches.updateDisLikeMenus(dislikeMenus);
    }


    private void recommend(Coaches coaches) {
        menuRecommender = new MenuRecommender(coaches);
        List<String> dailyCategories = menuRecommender.getDailyCategories();
        Map<String, List<String>> coachMenus = menuRecommender.getCoachMenus();
        menuView.printResult(dailyCategories, coachMenus);
    }
}
