package menu.controller;

import menu.domain.Coach;
import menu.domain.CoachService;
import menu.domain.MenuRecommendService;
import menu.ui.InputView;
import menu.ui.OutputView;
import menu.util.ShuffledListGenerator;

import java.util.Arrays;
import java.util.List;

public class MenuController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private final String START = "점심 메뉴 추천을 시작합니다.";
    private CoachService coachService = new CoachService();
    private MenuRecommendService menuRecommendService = new MenuRecommendService(new ShuffledListGenerator());

    public void doRecommendMenu() {
        System.out.println(START);
        registerCoaches();
        registerCannotEat();
        recommendMenu();
        outputView.resultOfRecommend(menuRecommendService.getRecommendedCategories(), coachService.getCoaches());
    }

    private void recommendMenu() {
        menuRecommendService.recommendMenu();
    }

    private void registerCoaches() {
        while (true) {
            try {
                coachService.registerCoaches(inputView.inputcoachNames());
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void registerCannotEat() {
        List<Coach> coaches = coachService.getCoaches();
        for (int i = 0; i < coaches.size(); i++) {
            try {
                coachService.registerCannotEatFoods(coaches.get(i),inputView.inputCannotEat(coaches.get(i).getName()));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                i--;
            }
        }
    }

}
