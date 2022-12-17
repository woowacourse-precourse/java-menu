package menu.domain;

import menu.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommand {
    private HashMap<String,List<String>> coachSet = new HashMap<>();
    public MenuRecommand(){}

    public void play() {
        List<String> coaches = InputView.inputCoaches();
        List<String[]> coachesMenu = new ArrayList<>();
        for (int i = 0; i < coaches.size(); i++)
            coachSet.put(coaches.get(i),InputView.inputInEdibleMenu(coaches.get(i)));
        List<Integer> category = Category.recommandCategory();

        Menu menu = new Menu(category);
        for (int i = 0; i < coaches.size(); i++)
            coachesMenu.add(menu.recommandMenu(coachSet.get(coaches.get(i))));
    }

    public void recommandMenu() {
    }
}
