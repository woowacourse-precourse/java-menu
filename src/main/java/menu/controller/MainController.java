package menu.controller;

import menu.utils.CategoryGenerator;
import menu.utils.MenuGenerator;
import menu.utils.Utils;
import menu.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainController {
    private List<Coach> coaches;
    public MainController() {
        Utils.initMenu();
        coaches = setCoachs();
    }

    public void run() {
        Style category = setCategory();
        recommendMenu(coaches, category);
        if (isComplete(coaches.get(0).getEatHistory().getEatMenus())) {
            run();
        }
    }

    public boolean checkCategory(Coach coach) {
        long count = coach.getEatHistory().getEatMenus().stream()
                .distinct()
                .count();
        if (coach.getEatHistory().getEatMenus().size() - count > 2) {
            return false;
        }
        return true;
    }

    public Style setCategory() {
        return CategoryGenerator.generate();
    }

    public boolean validateMenu(EatHistory eatHistory, Menu menu, List<Menu> cantEat) {
        if (eatHistory.validate(menu, cantEat)) {
            return true;
        }
        return false;
    }

    public void recommendMenu(List<Coach> coachs, Style category) {

        for (Coach coach : coachs) {
            Menu menu = MenuGenerator.generate(findCategoryMenu(category));
            EatHistory eatHistory = coach.getEatHistory();
            if (validateMenu(eatHistory, menu, coach.getCantEat())) {
                coach.getEatHistory().addEatMenu(menu);
                return;
            };
        }
        Utils.convertToMenuName(coaches.get(0).getEatHistory().getEatMenus());
        recommendMenu(coachs, category);
    }

    public List<Menu> findCategoryMenu(Style style) {
        return MenuRepository.getMenus().stream()
                .filter(menu -> menu.getStyle().equals(style))
                .collect(Collectors.toList());
    }

    public List<Coach> setCoachs() {
        List<Coach> coaches = new ArrayList<>();
        List<String> inputCoachNames = InputController.getInputCoachNames();
        for (String name : inputCoachNames) {
            List<Menu> cantEat = Utils.convertToMenu(InputController.getInputCantEat(name));
            coaches.add(new Coach(name, new EatHistory(), cantEat));
        }
        return coaches;
    }

    public boolean isComplete(List<Menu> eatMenus) {
        return eatMenus.size() == 5;
    }
}
