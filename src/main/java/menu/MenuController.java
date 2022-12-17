package menu;

import java.util.ArrayList;
import java.util.List;
import menu.type.CategoryType;
import menu.view.InputView;


public class MenuController {

    InputView inputView = new InputView();


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

        }

    }

}
