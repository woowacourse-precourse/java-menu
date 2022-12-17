package menu.domain.menu.validation.impl;

import menu.config.MenuInformation;
import menu.domain.menu.dto.InputValidationRequest;
import menu.domain.menu.dto.InputValidationResponse;
import menu.domain.menu.type.ValidationType;
import menu.domain.menu.validation.InputValidationChain;
import menu.domain.menu.validation.util.InputValidationUtil;

public class CoachNameValidateChain implements InputValidationChain {

    private InputValidationChain next;
    private static final String COACH_COUNT_ERROR_MESSAGE = "코치는 최소 %s명, 최대 %s명까지 입력 가능합니다.";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름은 최소 %s글자, 최대 %s글자까지 입력 가능합니다.";


    @Override
    public void setNext(InputValidationChain next) {
        this.next = next;
    }

    @Override
    public InputValidationResponse validate(InputValidationRequest request) {
        if (!request.getValidationTypes().contains(ValidationType.COACH_NAME)) {
            return next.validate(request);
        }
        InputValidationResponse detailResponse = validateDetail(
            request.getTarget().split(MenuInformation.INPUT_DIVIDE_POINT));
        if (detailResponse != null) {
            return detailResponse;
        }
        return next.validate(request);
    }

    private static InputValidationResponse validateDetail(String[] names) {
        InputValidationResponse validationCoachCountResponse = validateCoachCount(names);
        if (validationCoachCountResponse != null) {
            return validationCoachCountResponse;
        }
        return validateNameLength(names);
    }

    private static InputValidationResponse validateNameLength(String[] names) {
        for (String name : names) {
            if (!InputValidationUtil.validateLength(MenuInformation.COACH_NAME_MIN_LENGTH,
                MenuInformation.COACH_NAME_MAX_LENGTH, name)) {
                return new InputValidationResponse(false, String.format(NAME_LENGTH_ERROR_MESSAGE,
                    MenuInformation.COACH_NAME_MIN_LENGTH, MenuInformation.COACH_NAME_MAX_LENGTH));
            }
        }
        return null;
    }

    private static InputValidationResponse validateCoachCount(String[] names) {
        if (names.length < MenuInformation.COACH_MIN_COUNT || names.length > MenuInformation.COACH_MAX_COUNT) {
            return new InputValidationResponse(false, String.format(COACH_COUNT_ERROR_MESSAGE,
                MenuInformation.COACH_MIN_COUNT, MenuInformation.COACH_MAX_COUNT));
        }
        return null;
    }
}
