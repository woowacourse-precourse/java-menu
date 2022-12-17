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

}