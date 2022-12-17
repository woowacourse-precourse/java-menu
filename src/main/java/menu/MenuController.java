package menu;

import java.util.List;
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

    }

}
