package menu.controller;

import menu.service.InitService;
import menu.service.RandomService;
import menu.view.MainView;
import menu.view.NotEatView;
import menu.view.ResultView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainController {
    InitService initService = new InitService();
    RandomService randomService = new RandomService();
    public static final HashMap<String, List<String>> people = new HashMap<>();

    public void start() {
        initService.init();

        MainView.printMainScreen();

        List<String> names = MainView.getMainValue();
        startNotEat(names);
    }

    private void startNotEat(List<String> names) {
        names.forEach(name -> {
            people.put(name, NotEatView.getNotEatValue(name));
        });

        startPick(names);
    }

    private void startPick(List<String> names) {
        List<String> weekCategory = randomService.randomGetCategory();
        List<List<String>> resultMenu = new ArrayList<>();

        resultMenu.add(randomService.randomGetMenu(weekCategory.get(0), names));
        resultMenu.add(randomService.randomGetMenu(weekCategory.get(1), names));
        resultMenu.add(randomService.randomGetMenu(weekCategory.get(2), names));
        resultMenu.add(randomService.randomGetMenu(weekCategory.get(3), names));
        resultMenu.add(randomService.randomGetMenu(weekCategory.get(4), names));

        printAllResult(names, weekCategory, resultMenu);
    }

    private void printAllResult(List<String> names, List<String> weekCategory, List<List<String>> resultMenu) {
        ResultView.printResult();
        ResultView.printCategory(weekCategory);
        ResultView.printAll(names, resultMenu);
        ResultView.printEnd();
    }
}
