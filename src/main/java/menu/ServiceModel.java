package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ServiceModel {
    private final String coachName;
    private final List<String> cantEatMenu = new ArrayList<>();
    private final List<String> EatMenu = new ArrayList<>();

    public ServiceModel(String coachName) {
        this.coachName = coachName;
    }

    public void makeMenu(List<String> menuList) {
        String menu = Randoms.shuffle(menuList).get(0);
        while (EatMenu.contains(menu) || cantEatMenu.contains(menu)) {
            menu = Randoms.shuffle(menuList).get(0);
        }
        EatMenu.add(menu);
    }

    public void makeCantEatMenu(String[] menuList) {
        for (int i = 0; i < menuList.length; i++) {
            cantEatMenu.add(menuList[i]);
        }
    }

    public String getCoachName() {
        return coachName;
    }

    public List<String> getEatMenu() {
        return EatMenu;
    }
}