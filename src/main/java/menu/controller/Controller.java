package menu.controller;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import menu.domain.MenuService;
import menu.dto.CoachDto;
import menu.dto.CoachNameDto;
import menu.dto.CoachNamesDto;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    private final MenuService menuService = new MenuService();

    public void run() {
        readCoachNames();
        readCoachCantEatMenu();
    }

    private void readCoachCantEatMenu() {
        CoachNamesDto coachesNames = menuService.getCoachesNames();
        for (String coachName : coachesNames.getNames()) {
            repeat(this::initialCoachCantEatMenu, coachName);
        }
    }

    private void initialCoachCantEatMenu(String coachName) {
        CoachDto coach = repeat(InputView::readCantEatMenu, new CoachNameDto(coachName));
        menuService.initialCoachCantEatMenus(coach);
    }

    private void readCoachNames() {
        repeat(InputView::readCoachNames, menuService::initialCoachesNames);
    }

    private <T, R> R repeat(Function<T, R> initializer, T value) {
        try {
            return initializer.apply(value);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return repeat(initializer, value);
        }
    }

    private <T> void repeat(Supplier<T> reader, Consumer<T> initializer) {
        try {
            initializer.accept(reader.get());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            repeat(reader, initializer);
        }
    }

    private <T> void repeat(Consumer<T> initializer, T value) {
        try {
            initializer.accept(value);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            repeat(initializer, value);
        }
    }
}
