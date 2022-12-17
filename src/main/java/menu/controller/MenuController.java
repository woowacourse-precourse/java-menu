package menu.controller;

import static menu.controller.exception.Exception.exceptionError;

import java.util.List;
import java.util.stream.Collectors;
import menu.service.Menu;
import menu.service.dto.RecommendResultDto;
import menu.service.dto.MenuDto;
import menu.service.dto.CoachNameDto;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final Menu menu;

    public MenuController(final Menu menu) {
        this.menu = menu;
    }

    public void run() {
        printStartMessage();
        final List<String> coachNames = exceptionError(this::getNames);
        final List<List<String>> menus = getMenus(coachNames);
        printResult(coachNames, menus);
    }

    private void printStartMessage() {
        OutputView.printStart();
    }

    private List<String> getNames() {
        final CoachNameDto coachNameDto = InputView.getNames();
        menu.validateCoachNames(coachNameDto);
        return coachNameDto.getNames();
    }

    private List<List<String>> getMenus(final List<String> names) {
        return names.stream().
                map(name -> exceptionError(() -> getCoachMenu(name)))
                .collect(Collectors.toList());
    }

    private List<String> getCoachMenu(final String name) {
        final MenuDto menuDto = InputView.getMenus(name);
        menu.validateMenus(menuDto);
        return menuDto.getMenus();
    }

    private void printResult(final List<String> names, final List<List<String>> menus) {
        final RecommendResultDto resultDto = menu.recommend(names, menus);
        OutputView.printResult(resultDto);
    }
}