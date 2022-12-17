package menu.controller;

import menu.service.LunchMenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static menu.view.validation.MenuValidation.menuValidation;
import static menu.view.validation.NameValidation.nameValidation;

public class LunchMenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LunchMenuService lunchMenuService;
    private List<String> names;
    private List<List<String>> results;
    private List<List<String>> menus;

    public LunchMenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lunchMenuService = new LunchMenuService();

        this.names = new ArrayList<>();
        this.results = new ArrayList<>();
        this.menus = new ArrayList<>();
    }

    public void start() {
        String inputNames = inputNames();
        int countPeople = countNames(inputNames);
        storageMenus(countPeople);

        for (int i = 0; i < 5; i++) {
            recommendMenu(i, countPeople);
        }
        outputView.printResult(lunchMenuService.changeCategoryToString(), names, results);
    }

    public void storageMenus(int people) {
        for (int i = 0; i < people; i++) {
            menus.add(splitMenus(inputMenus(i)));
            results.add(new ArrayList<>());
        }
    }

    public void recommendMenu(int index, int people) {
        for (int i = 0; i < people; i++) {
            while (true) {
                String randomRecommendMenu = lunchMenuService.randomRecommendMenu(index);
                if (lunchMenuService.checkDuplicate(menus.get(i), results.get(i), randomRecommendMenu)) {
                    results.get(i).add(randomRecommendMenu);
                    break;
                }
            }
        }
    }

    public List<String> splitMenus(String input) {
        String[] values = input.split(",");
        List<String> cannotEatMenus = new ArrayList<>();
        for (String value : values) {
            cannotEatMenus.add(value);
        }
        return cannotEatMenus;
    }

    public int countNames(String input) {
        String[] values = input.split(",");
        addNames(values);
        return values.length;
    }

    public void addNames(String[] values) {
        for (String value : values) {
            names.add(value);
        }
    }

    private String inputNames() {
        String input;
        do {
            input = inputView.readNames();
        } while (!nameValidation(input));
        return input;
    }

    private String inputMenus(int index) {
        String input;
        do {
            input = inputView.readMenus(names.get(index));
        } while (!menuValidation(input));
        return input;
    }
}