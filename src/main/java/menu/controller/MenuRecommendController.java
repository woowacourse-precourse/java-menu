package menu.controller;

import menu.common.config.MenuRecommendConfig;
import menu.domain.Group;
import menu.usecase.MenuRecommendUseCase;
import menu.usecase.SelectCategoryUseCase;

public class MenuRecommendController {

    private final MenuRecommendUseCase menuRecommendUseCase;
    private final SelectCategoryUseCase selectCategoryUseCase;

    public MenuRecommendController(final MenuRecommendConfig config) {
        this.menuRecommendUseCase = config.menuRecommendUseCase();
        this.selectCategoryUseCase = config.selectCategoryUseCase();
    }

    /**
     * 메뉴 추천
     */
    public void recommend(final Group group) {
        selectCategoryUseCase.command(
                new SelectCategoryUseCase.Command(group)
        );
        menuRecommendUseCase.command(
                new MenuRecommendUseCase.Command(group)
        );
    }
}
