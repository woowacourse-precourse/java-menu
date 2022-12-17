package menu.domain;

import menu.view.InputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommand {
    private HashMap<String,List<String>> hs = new HashMap<>();
    public MenuRecommand(){}

    public void play() {
        List<String> coaches = InputView.inputCoaches();
        for (int i = 0; i < coaches.size(); i++)
            hs.put(coaches.get(i),InputView.inputInEdibleMenu(coaches.get(i)));
    }
}
