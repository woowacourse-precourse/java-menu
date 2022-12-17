package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;

import java.util.List;

public class MenuRandomRecommender {

    public String recommend(List<String> menus, Coach coach) {
        String menu = Randoms.shuffle(menus).get(0);

        if (coach.isHateMenu(menu) || coach.isRecommendedMenu(menu)) {
            return recommend(menus, coach);
        }

        return menu;
    }
}
