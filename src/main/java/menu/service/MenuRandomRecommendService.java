package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Coach;

public class MenuRandomRecommendService implements MenuRecommendService {

    @Override
    public void recommend(Coach coach, Category category) {

        String menu;
        do {
            menu = Randoms.shuffle(category.getMenus()).get(0);
        } while (isNotSelectableMenu(coach, menu));
        coach.getSelectedMenus().add(menu);
    }

    private boolean isNotSelectableMenu(Coach coach, String menu) {
        return coach.getSelectedMenus().contains(menu) || coach.getUnEatableFood().contains(menu);
    }
}
