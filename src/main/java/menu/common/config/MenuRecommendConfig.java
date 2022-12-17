package menu.common.config;

import menu.service.MenuRecommend;
import menu.service.SelectCategory;
import menu.usecase.MenuRecommendUseCase;
import menu.usecase.SelectCategoryUseCase;

public class MenuRecommendConfig {

    public MenuRecommendUseCase menuRecommendUseCase() {
        return new MenuRecommend();
    }

    public SelectCategoryUseCase selectCategoryUseCase() {
        return new SelectCategory();
    }
}
