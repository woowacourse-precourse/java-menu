package menu.service;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;
import static menu.domain.Category.findMenuByName;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public class MenuRecommender {

    public Menu recommendMenuForCoach(Coach coach, Category category) {
        List<String> categoryMenus = category.getMenuNames();
        while (true) {
            Menu menu = findMenuByName(shuffle(categoryMenus).get(0));
            if (!coach.isValidMenu(menu) || coach.isAlreadyRecommended(menu)) {
                continue;
            }
            return menu;
        }
    }
}
