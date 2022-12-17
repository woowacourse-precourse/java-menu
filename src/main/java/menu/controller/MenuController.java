package menu.controller;

import menu.model.Coach;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;
    private final List<Coach> coaches = new ArrayList<>();

    public MenuController(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }

    public void start() {
        List<String> coachNames = inputView.getCoachName();
        for (String name : coachNames) {
            initCoaches(name);
        }

        List<String> categoryNames = menuService.getCategoryNames();
        outputView.printMenuResult(categoryNames, coaches);
    }

    private void initCoaches(String name) {
        Coach coach = new Coach(name);
        setCoachNoMenu(coach);
        setCoachMyMenu(coach);
        coaches.add(coach);
    }

    private void setCoachNoMenu(Coach coach) {
        List<String> noMenu = inputView.getNoMenu(coach);
        coach.setNoMenu(noMenu);
    }

    private void setCoachMyMenu(Coach coach) {
        menuService.getMenus(coach);
    }
}
