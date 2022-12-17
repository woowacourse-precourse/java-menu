package menu.controller;

import menu.domain.Group;
import menu.usecase.MenuRecommendUseCase;

public class MenuRecommendController {

    private final MenuRecommendUseCase menuRecommendUseCase;

    public MenuRecommendController(final MenuRecommendUseCase menuRecommendUseCase) {
        this.menuRecommendUseCase = menuRecommendUseCase;
    }

    /**
     * 메뉴 추천
     */
    public void recommend(final Group group) {
        menuRecommendUseCase.command(
                new MenuRecommendUseCase.Command(group));
    }
}
