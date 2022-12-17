package menu.common.input;

import menu.domain.menu.validation.InputValidationChain;

public interface InputStrategy<T> {

    T executeInput(InputValidationChain validator) throws IllegalArgumentException;
}
