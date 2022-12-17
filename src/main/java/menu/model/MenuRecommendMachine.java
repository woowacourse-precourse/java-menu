package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MenuRecommendMachine {

    private static final int RECOMMEND_MENU_INDEX = 0;

    public String recommend(Category recommendedCategory) {
        List<String> menusByCategory = Category.getMenusByCategory(recommendedCategory);
        return Randoms.shuffle(menusByCategory).get(RECOMMEND_MENU_INDEX);
    }
}
