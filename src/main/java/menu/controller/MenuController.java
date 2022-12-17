package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.HateFoods;
import menu.domain.Human;
import menu.domain.KindAndFood;
import menu.domain.Names;
import menu.domain.RandomMenu;
import menu.domain.Result;
import menu.utill.CategoryMaker;
import menu.utill.Convertor;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private InputController inputController = new InputController();
    private RandomMenu randomMenu = new RandomMenu();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private List<Result> menus = new ArrayList<>();
    private List<String> categories;


    public void init() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    private void start() {
        outputView.start();
        Names names = inputController.getNames();
        List<String> targetNames = names.getNames();
        categories = CategoryMaker.make();
        targetNames.stream()
                .forEach(name -> {
                    play(name);
                });
        outputView.viewMenus(menus, categories);

    }

    private void play(String name) {
        HateFoods hateFoods = inputController.getHateFoods(name);
        List<String> targetHateFoods = hateFoods.getFoods();
        Human human = new Human(name, new ArrayList<>(), targetHateFoods);
        randomMenu.select(human, categories);
        List<KindAndFood> kindAndFood = human.getKindAndFoods();
        save(name, kindAndFood, categories);
    }

    private void save(String name, List<KindAndFood> kindAndFood, List<String> categories) {
        List<String> foods = Convertor.toFoodList(kindAndFood);
        Result result = new Result(name, foods);
        menus.add(result);
    }
}
