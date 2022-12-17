package menu.domain.menu.validation.impl;

import menu.config.MenuInformation;
import menu.domain.menu.dto.InputValidationRequest;
import menu.domain.menu.dto.InputValidationResponse;
import menu.domain.menu.type.ValidationType;
import menu.domain.menu.validation.InputValidationChain;

public class ForbiddenFoodValidateChain implements InputValidationChain {

    private InputValidationChain next;
    private static final String FORBIDDEN_FOOD_COUNT_ERROR_MESSAGE = "못 먹는 음식은 최대 %s명까지 입력 가능합니다.";

    @Override
    public void setNext(InputValidationChain next) {
        this.next = next;
    }

    @Override
    public InputValidationResponse validate(InputValidationRequest request) {
        if (!request.getValidationTypes().contains(ValidationType.FORBIDDEN_FOOD)) {
            return next.validate(request);
        }
        String[] names = request.getTarget().split(MenuInformation.INPUT_DIVIDE_POINT);
        InputValidationResponse validateFoodCountResponse = validateFoodCount(names);
        if (validateFoodCountResponse != null) {
            return validateFoodCountResponse;
        }
        return next.validate(request);
    }

    private InputValidationResponse validateFoodCount(String[] names) {
        if (names.length > MenuInformation.FORBIDDEN_FOOD_MAX_COUNT) {
            return new InputValidationResponse(false,
                String.format(FORBIDDEN_FOOD_COUNT_ERROR_MESSAGE, MenuInformation.FORBIDDEN_FOOD_MAX_COUNT));
        }
        return null;
    }
}
