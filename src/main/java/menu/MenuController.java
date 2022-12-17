package menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import menu.type.CategoryType;
import menu.view.InputView;
import menu.view.OutputView;


public class MenuController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CategoryMap categoryMap = new CategoryMap(new HashMap<>());

    public void run() {
        List<String> coachLists = inputView.getCoachList();
        CoachHates coachHates = new CoachHates();
        for (int i = 0; i < coachLists.size(); i++) {
            List<String> hateFoods = inputView.getHateList(coachLists.get(i));
            coachHates.updateHateMap(coachLists.get(i), hateFoods);
        }
        MenuChoicer menuChoices = new MenuChoicer(coachLists, coachHates);
        List<CategoryType> chosenCategoryList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CategoryType chosenCategoryType = menuChoices.chooseRandomCategory();
            chosenCategoryList.add(chosenCategoryType);
            for (int j = 0; j < coachLists.size(); j++) {
                List<String> menus = categoryMap.getFoodList(chosenCategoryType);
                String menu = menuChoices.chooseRandomMenu(menus);
            }
        }

    }

}
