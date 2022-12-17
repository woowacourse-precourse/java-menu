package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

public class RecommendationMachine {
    public Category category() {
        while (true) {
            Category category = randomCategory();
            if (Day.isAvailableCategory(category)) {
                return category;
            }
        }
    }

    private Category randomCategory() {
        return Category.fromCode(String.valueOf(Randoms.pickNumberInRange(1, 5)));
    }

    public Menu menu(Menus allMenus, Category category, Menus notAllowed) {
        while (true) {
            Menu menu = randomMenu(allMenus);
            if (!Objects.isNull(menu) && menu.ofCategory(category)) {
                return menu;
            }
        }
    }

    private Menu randomMenu(Menus allMenus) {
        String menuName = Randoms.shuffle(allMenus.getNames()).get(0);
        return allMenus.findMenu(menuName);
    }
}
