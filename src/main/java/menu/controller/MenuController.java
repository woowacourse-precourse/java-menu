package menu.controller;

import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private final MenuService menuService;
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(MenuService menuService, InputView inputView, OutputView outputView) {
        this.menuService = menuService;
        this.inputView = inputView;
        this.outputView = outputView;

        inputView.init();
    }

    public void setCoaches() {
        while (true) {
            try {
                menuService.setCoachesName(inputView.readCoachesName());
                break;
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }

    public void setAvoidance() {
        List<String> inputs = new ArrayList<>();
        for (String coach : menuService.getCoachesName())
            inputs.add(getAvoidanceInput(coach));

        menuService.setAvoidance(inputs);
    }

    public void recommend() {
        menuService.setCategories();
        menuService.setMenus();

        outputView.printResult(
                menuService.getCategories(),
                menuService.getCoachesMenus(),
                menuService.getCoachesName()
        );
    }

    private String getAvoidanceInput(String coach) {
        while(true){
            try {
                String avoidance = inputView.readCoachesAvoidance(coach);
                menuService.validateAvoidanceInput(avoidance);

                return avoidance;
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }
}
