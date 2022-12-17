package menu.controller;

import menu.domain.Coach;
import menu.domain.CoachService;
import menu.domain.MenuRecommendService;
import menu.ui.InputView;
import menu.ui.OutputView;

import java.util.Arrays;
import java.util.List;

public class MenuController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private final String START = "점심 메뉴 추천을 시작합니다.";
    private CoachService coachService = new CoachService();
    private MenuRecommendService menuRecommendService = new MenuRecommendService();

    public void doRecommendMenu() {
        System.out.println(START);
        registercoaches();
        registerCannotEat();
        recommendMenu();
        outputView.resultOfRecommend(menuRecommendService.getRecommendedCategories(), coachService.getcoaches());
    }

    private void recommendMenu() {
        menuRecommendService.recommendMenu();
    }

    private void registercoaches() {
        while (true) {
            try {
                coachService.registercoaches(inputView.inputcoachNames());
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void registerCannotEat() {
        List<Coach> coaches = coachService.getcoaches();
        for (int i = 0; i < coaches.size(); i++) {
            try {
                coaches.get(i).setCannotEatFoods(Arrays.asList(inputView.inputCannotEat(coaches.get(i).getName()).split(",")));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                i--;
            }
        }
    }

}
