package menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import menu.domain.CategoryMap;
import menu.domain.CoachHates;
import menu.domain.MenuChoicer;
import menu.type.CategoryType;
import menu.util.InputExceptionHandler;
import menu.view.OutputView;

public class MenuApplication {
    private static final int DAYS = 5;

    InputExceptionHandler inputExceptionHandler = new InputExceptionHandler();
    OutputView outputView = new OutputView();
    CategoryMap categoryMap = new CategoryMap(new HashMap<>());

    public void run() {
        List<String> coachLists = inputExceptionHandler.getCoachList();
        CoachHates coachHates = new CoachHates();
        for (int i = 0; i < coachLists.size(); i++) {
            List<String> hateFoods = inputExceptionHandler.getHateList(coachLists.get(i));
            coachHates.updateHateMap(coachLists.get(i), hateFoods);
        }
        MenuChoicer menuChoices = new MenuChoicer(coachLists, coachHates);
        List<CategoryType> chosenCategoryList = getRecommendedMenuList(coachLists, menuChoices);
        showChoiceResult(coachLists, menuChoices, chosenCategoryList);
    }

    private List<CategoryType> getRecommendedMenuList(List<String> coachLists, MenuChoicer menuChoices) {
        List<CategoryType> recommendedMenuList = new ArrayList<>();
        for (int i = 0; i < DAYS; i++) {
            CategoryType chosenCategoryType = menuChoices.chooseRandomCategory(recommendedMenuList);
            recommendedMenuList.add(chosenCategoryType);
            for (int j = 0; j < coachLists.size(); j++) {
                List<String> menus = categoryMap.getFoodList(chosenCategoryType);
                String menu = menuChoices.chooseRandomMenuUntilDoesntExists(menuChoices.getCoachMenus(coachLists.get(j)), menus);
                menuChoices.updateChosenMenu(coachLists.get(j), menu);
            }
        }
        return recommendedMenuList;
    }

    private void showChoiceResult(List<String> coachLists, MenuChoicer menuChoices, List<CategoryType> chosenCategoryList) {
        outputView.printResultInit();
        outputView.printCategory(chosenCategoryList);
        for (int i = 0; i < coachLists.size(); i++) {
            outputView.printCoachMenu(coachLists.get(i), menuChoices.getChosenMenuMap().get(coachLists.get(i)));
        }
        outputView.printEnd();
    }

}
