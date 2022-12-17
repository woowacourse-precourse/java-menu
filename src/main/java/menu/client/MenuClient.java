package menu.client;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import menu.di.MenuUseCase;
import menu.di.RecommendResultDto;
import menu.di.ValidateMenuCommand;
import menu.di.ValidateNameCommand;

public class MenuClient {

    private final MenuUseCase menuUseCase;

    public MenuClient(MenuUseCase menuUseCase) {
        this.menuUseCase = menuUseCase;
    }

    public void run() {
        printStartMessage();
        List<String> names = handleError(this::askNames);
        List<List<String>> menus = askMenus(names);
        printResult(names, menus);
    }


    private void printStartMessage() {
        OutputView.printStartMessage();
    }

    private List<String> askNames() {
        ValidateNameCommand validateNameCommand = InputView.askNames();
        menuUseCase.validateNames(validateNameCommand);
        return validateNameCommand.getNames();
    }

    private List<List<String>> askMenus(List<String> names) {
        List<List<String>> menus = new ArrayList<>();
        for (String name : names) {
            menus.add(handleError(() -> askOneCoachMenu(name)));
        }
        return menus;
    }

    private List<String> askOneCoachMenu(String name) {
        ValidateMenuCommand validateMenuCommand = InputView.askMenus(name);
        menuUseCase.validateMenus(validateMenuCommand);
        return validateMenuCommand.getMenus();
    }

    private void printResult(List<String> names, List<List<String>> menus) {
        RecommendResultDto resultDto = menuUseCase.recommend(names, menus);
        OutputView.printResult(resultDto);
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
