package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        while (true) {
            try {
                menuService.setAvoidance(getInputs());
                break;
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }

    public void recommend() {
        menuService.setCategories();
        menuService.setMenus();

        outputView.printResult(
                getCategories(),
                getMenus(),
                menuService.getCoachesName()
        );
    }

    private List<String> getCategories() {
        return menuService.getCategories().stream()
                .map(Category::getCategoryName)
                .collect(Collectors.toList());
    }

    private List<List<String>> getMenus() {
        return menuService.getCoaches().stream()
                .map(Coach::getRecommended)
                .collect(Collectors.toList());
    }

    private List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        for (String coach : menuService.getCoachesName()) {
            String menu = inputView.readCoachesAvoidance(coach);
            Category.isValidMenu(menu);

            inputs.add(menu);
        }

        return inputs;
    }
}
