package menu;


import menu.domain.Coach;
import menu.domain.MenuService;
import menu.domain.constants.Category;
import menu.domain.constants.DaysOfWeek;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void generate() {
        outputView.printStart();
        MenuService menuService = createMenuService();

        menuService.recommendMenu();
        printResult(menuService);

        outputView.printEnd();
    }

    public MenuService createMenuService() {
        List<Coach> coaches = getCoaches();
        addUnableToEatMenusToCoaches(coaches);

        return new MenuService(coaches);
    }

    public void addUnableToEatMenusToCoaches(List<Coach> coaches) {
        for (Coach coach : coaches) {
            List<String> unableToEatMenus = getUnableToEatMenus(coach.getName());
            coach.setUnableToEatMenus(unableToEatMenus);
        }
    }

    public List<Coach> getCoaches() {
        try {
            List<String> coachNames = inputView.readCoachNames();
            return creatCoachList(coachNames);

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return getCoaches();
    }

    public List<String> getUnableToEatMenus(String coachName) {
        try {
            List<String> unableToEatMenus = inputView.readUnableToEatMenus(coachName);
            Category.validateMenu(unableToEatMenus); //카테고리에 있는 메뉴인지 확인
            return unableToEatMenus;

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return getUnableToEatMenus(coachName);
    }

    public void printResult(MenuService menuService) {
        List<String> daysOfWeek = DaysOfWeek.getDaysOfWeek();
        List<String> categories = menuService.getRecommendCategories();
        List<List<String>> menusOfCoach = menuService.getRecommendMenus();
        outputView.printResult(daysOfWeek, categories, menusOfCoach);
    }


    public List<Coach> creatCoachList(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            coaches.add(new Coach(coachName));
        }
        return coaches;
    }

}
