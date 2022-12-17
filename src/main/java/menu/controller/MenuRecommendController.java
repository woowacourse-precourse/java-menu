package menu.controller;

import menu.domain.Group;
import menu.usecase.MenuRecommendUseCase;
import menu.usecase.SelectCategoryUseCase;

public class MenuRecommendController {

    private final MenuRecommendUseCase menuRecommendUseCase;
    private final SelectCategoryUseCase selectCategoryUseCase;

    public MenuRecommendController(final MenuRecommendUseCase menuRecommendUseCase,
                                   final SelectCategoryUseCase selectCategoryUseCase) {
        this.menuRecommendUseCase = menuRecommendUseCase;
        this.selectCategoryUseCase = selectCategoryUseCase;
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
