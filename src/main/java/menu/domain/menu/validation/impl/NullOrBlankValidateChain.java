package menu.domain.menu.validation.impl;

import menu.domain.menu.dto.InputValidationRequest;
import menu.domain.menu.dto.InputValidationResponse;
import menu.domain.menu.type.ValidationType;
import menu.domain.menu.validation.InputValidationChain;

public class NullOrBlankValidateChain implements InputValidationChain {

    private InputValidationChain next;
    private static final String NULL_OR_BLANK_MESSAGE = "빈 값은 입력할 수 없습니다.";

    @Override
    public void setNext(InputValidationChain next) {
        this.next = next;
    }

    @Override
    public InputValidationResponse validate(InputValidationRequest request) {
        if (!request.getValidationTypes().contains(ValidationType.NULL_OR_BLANK)) {
            return next.validate(request);
        }
        if (request.getTarget() == null || request.getTarget().isBlank()) {
            return new InputValidationResponse(false, NULL_OR_BLANK_MESSAGE);
        }
        return next.validate(request);
    }
}
