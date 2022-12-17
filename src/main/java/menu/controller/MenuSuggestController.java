package menu.controller;

import menu.model.coach.Coach;
import menu.model.menu.Category;
import menu.model.menu.Menu;
import menu.model.menu.RandomCategoryGenerator;
import menu.model.menu.RandomMenuGenerator;
import menu.model.menutable.MenuTableGenerator;
import menu.model.menutable.WeeklyMenuTable;

import java.util.ArrayList;
import java.util.List;

public class MenuSuggestController {
    private InputManager inputManager = new InputManager();
    private OutputManager outputManager = new OutputManager();

    public void run() {
        outputManager.printStart();
        List<Coach> coachList = inputManager.getCoachListInput();
        for(Coach coach : coachList) {
            setCoachHatingMenu(coach);
        }

        RandomCategoryGenerator randomCategoryGenerator = new RandomCategoryGenerator(2);
        List<Category> categoryList = randomCategoryGenerator.pickCategories(5);
        WeeklyMenuTable weeklyMenuTable = MenuTableGenerator.makeWeeklyMenuTable(categoryList, coachList);

        outputManager.printWeeklyMenuTable(weeklyMenuTable);
        outputManager.printEnd();
    }

    private void setCoachHatingMenu(Coach coach) {
        List<Menu> hatingMenus = inputManager.getMenuListInput(coach.getName());
        for(Menu hatingMenu : hatingMenus) {
            coach.addHatingMenu(hatingMenu);
        }
    }
}
