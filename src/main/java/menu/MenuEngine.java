package menu;

import menu.maker.CategoryMaker;
import menu.maker.MenuMaker;
import menu.model.Category;
import menu.view.ConsoleUtil;

import java.util.List;
import java.util.Map;

public class MenuEngine {

    public void start() {
        printGameStart();

        List<String> coachNames = ConsoleUtil.inputCoachName();
        Map<String, List<String>> exceptedFoods = ConsoleUtil.inputExceptedFood(coachNames);

        Category category = new Category();
        CategoryMaker categoryMaker = new CategoryMaker();
        categoryMaker.addCategory(category);

        MenuMaker menuMaker = new MenuMaker();
        Map<String, List<String>> menu = menuMaker.addMenu(category, coachNames, exceptedFoods);

        ConsoleUtil.outputGameResult(category, menu);
    }

    private static void printGameStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }
}
