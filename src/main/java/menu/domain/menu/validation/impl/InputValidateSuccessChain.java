package menu.domain.menu.validation.impl;

import menu.domain.menu.dto.InputValidationRequest;
import menu.domain.menu.dto.InputValidationResponse;
import menu.domain.menu.validation.InputValidationChain;

public class InputValidateSuccessChain implements InputValidationChain {

    @Override
    public void setNext(InputValidationChain next) {}

    @Override
    public InputValidationResponse validate(InputValidationRequest request) {
        return new InputValidationResponse(true);
    }
}
