package menu.domain;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommand {
    private HashMap<String,List<String>> coachSet = new HashMap<>();
    public MenuRecommand(){}

    public void play() {
        OutputView.printStartMsg();

        List<String> coaches = InputView.inputCoaches();
        HashMap<String,List<String>> coachesHs = new HashMap<>();
        for (int i = 0; i < coaches.size(); i++) {
            List<String> l = new ArrayList<>();
            coachSet.put(coaches.get(i), InputView.inputInEdibleMenu(coaches.get(i)));
            coachesHs.put(coaches.get(i),l);
        }
        Category category = new Category();

        for (int i = 0; i < 5; i ++) {
            Integer now_category = category.recommandDayCategory();
            for (int j = 0; j < coaches.size(); j++)
                coachesHs.get(coaches.get(j)).add(recommandMenuByCategory(coachSet.get(coaches.get(j)),now_category));
        }

        OutputView.printResult(coaches,coachesHs,category.getCategory());
    }

    public String recommandMenuByCategory(List<String> inEdibleMenu, Integer category) {
        Menu menu = new Menu(category);
        return menu.recommandMenu(inEdibleMenu);
    }
}
