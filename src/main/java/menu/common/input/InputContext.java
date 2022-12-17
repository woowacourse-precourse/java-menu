package menu.common.input;


import menu.common.exception.ErrorInformation;
import menu.domain.menu.validation.InputValidationChain;

public class InputContext {

    public <T> T workWithInputStrategy(InputValidationChain validator, InputStrategy<T> inputStrategy) {
        T input = null;
        while (input == null) {
            try {
                input = inputStrategy.executeInput(validator);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorInformation.ERROR_PREFIX + e.getMessage());
            }
        }
        return input;
    }
}
