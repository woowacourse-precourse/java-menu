package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;


public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService service;

    public MenuController(InputView inputView, OutputView outputView, MenuService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void execute() {
        outputView.start();
        List<String> coachNames = inputView.enterCoach();
        List<Coach> coaches = inputView.enterMenuByAll(coachNames);
        outputView.recommendResult(coaches, recommendMenu(coaches));
    }

    public Category recommendMenu(List<Coach> coaches) {
        return service.recommendMenuFinal(coaches);
    }



}
