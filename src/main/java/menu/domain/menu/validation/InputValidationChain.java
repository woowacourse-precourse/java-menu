package menu.domain.menu.validation;

import menu.domain.menu.dto.InputValidationRequest;
import menu.domain.menu.dto.InputValidationResponse;

public interface InputValidationChain {

    void setNext(InputValidationChain next);

    InputValidationResponse validate(InputValidationRequest request);
}
