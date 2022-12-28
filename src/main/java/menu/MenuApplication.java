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
        List<CategoryType> chosenCategoryList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CategoryType chosenCategoryType = menuChoices.chooseRandomCategory(chosenCategoryList);
            chosenCategoryList.add(chosenCategoryType);
            for (int j = 0; j < coachLists.size(); j++) {
                List<String> menus = categoryMap.getFoodList(chosenCategoryType);
                String menu = menuChoices.chooseRandomMenuUntilDoesntExists(menuChoices.getCoachMenus(coachLists.get(j)), menus);
                menuChoices.updateChosenMenu(coachLists.get(j), menu);
            }
        }
        showChoiceResult(coachLists, menuChoices, chosenCategoryList);
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
