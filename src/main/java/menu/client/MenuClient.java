package menu.client;

import java.util.function.Supplier;
import menu.di.MenuUseCase;
import menu.di.ValidateMenuCommand;
import menu.di.ValidateNameCommand;

public class MenuClient {

    private final MenuUseCase menuUseCase;

    public MenuClient(MenuUseCase menuUseCase) {
        this.menuUseCase = menuUseCase;
    }

    public void run() {
        printStartMessage();
        ValidateNameCommand validateNameCommand = handleError(this::askNames);
        ValidateMenuCommand validateMenuCommand = handleError(this::askMenus);
        printResult(validateNameCommand, validateMenuCommand);
    }

    private void printStartMessage() {
        OutputView.printStartMessage();
    }

    private ValidateNameCommand askNames() {
        ValidateNameCommand validateNameCommand = InputView.askNames();
        menuUseCase.validateNames(validateNameCommand);
        return validateNameCommand;
    }

    private ValidateMenuCommand askMenus() {
        return null;
    }

    private void printResult(ValidateNameCommand validateNameCommand, ValidateMenuCommand validateMenuCommand) {

    }

    private void handleError(Runnable something) {
        try {
            something.run();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            handleError(something);
        }
    }

    private <T> T handleError(Supplier<T> something) {
        try {
            return something.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return handleError(something);
        }
    }

    private <T, R> R handleError(Function<T, R> something, T argument) {
        try {
            return something.apply(argument);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return handleError(something, argument);
        }
    }
}
