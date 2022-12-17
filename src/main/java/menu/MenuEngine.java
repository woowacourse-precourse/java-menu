package menu;

import menu.maker.CategoryMaker;
import menu.maker.MenuMaker;
import menu.model.Category;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.Map;

public class MenuEngine {

    public void start() {
        System.out.println("점심 메뉴 추천을 시작합니다.");

        InputView inputView = new InputView();

        List<String> coachNames = inputView.readCoachName();

        Map<String, List<String>> exceptedFoods = inputView.readExceptedFood(coachNames);

        Category category = new Category();

        CategoryMaker categoryMaker = new CategoryMaker();

        categoryMaker.addCategory(category);

        MenuMaker menuMaker = new MenuMaker();

        Map<String, List<String>> stringListMap = menuMaker.addMenu(category, coachNames, exceptedFoods);

        OutputView.printDay();
        OutputView.printCategory(category);
        OutputView.printMenu(stringListMap);
    }
}
