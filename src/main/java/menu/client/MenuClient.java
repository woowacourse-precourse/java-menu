package menu.client;

import java.util.function.Supplier;
import menu.di.ValidateMenuCommand;
import menu.di.ValidateNameCommand;

public class MenuClient {

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
        return InputView.askNames();
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
}
