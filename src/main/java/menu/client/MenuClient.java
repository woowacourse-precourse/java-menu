package menu.client;

import menu.di.ValidateMenuCommand;
import menu.di.ValidateNameCommand;

public class MenuClient {

    public void run() {
        printStartMessage();
        ValidateNameCommand validateNameCommand = askNames();
        ValidateMenuCommand validateMenuCommand = askMenus();
        printResult(validateNameCommand, validateMenuCommand);
    }

    private void printStartMessage() {
    }

    private ValidateNameCommand askNames() {
        return null;
    }

    private ValidateMenuCommand askMenus() {
        return null;
    }

    private void printResult(ValidateNameCommand validateNameCommand, ValidateMenuCommand validateMenuCommand) {

    }
}
