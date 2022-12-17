package menu.config;

import menu.common.input.InputContext;
import menu.common.operate.OperateContext;
import menu.domain.menu.controller.MenuController;
import menu.domain.menu.repository.CategoryHistoryRepositoryImpl;
import menu.domain.menu.repository.FoodRepositoryImpl;
import menu.domain.menu.service.MenuRecommendService;
import menu.domain.menu.service.MenuRecommendServiceImpl;
import menu.domain.menu.validation.InputValidationChain;
import menu.domain.menu.validation.impl.CoachNameValidateChain;
import menu.domain.menu.validation.impl.ForbiddenFoodValidateChain;
import menu.domain.menu.validation.impl.InputValidateSuccessChain;
import menu.domain.menu.validation.impl.NullOrBlankValidateChain;

public class MenuConfig {

    public static MenuController config() {
        return new MenuController(recommendServiceDI(), FoodRepositoryImpl.getInstance(), inputValidationChain(),
            new InputContext(), new OperateContext());
    }

    private static MenuRecommendService recommendServiceDI() {
        return new MenuRecommendServiceImpl(FoodRepositoryImpl.getInstance(), new CategoryHistoryRepositoryImpl());
    }

    private static InputValidationChain inputValidationChain() {
        InputValidationChain nullOrBlankValidateChain = new NullOrBlankValidateChain();
        InputValidationChain coachNameValidateChain = new CoachNameValidateChain();
        InputValidationChain forbiddenFoodValidateChain = new ForbiddenFoodValidateChain();
        InputValidationChain inputValidateSuccessChain = new InputValidateSuccessChain();
        nullOrBlankValidateChain.setNext(coachNameValidateChain);
        coachNameValidateChain.setNext(forbiddenFoodValidateChain);
        forbiddenFoodValidateChain.setNext(inputValidateSuccessChain);
        return nullOrBlankValidateChain;
    }
}
