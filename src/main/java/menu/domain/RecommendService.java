package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecommendService {

    private final List<Category> categorys;
    private final Coaches coaches;

    public RecommendService(Coaches coaches) {
        this.categorys = new ArrayList<>();
        this.coaches = coaches;
    }

    public MenuResult recommend(CategoryGenerator categoryGenerator) {
        while (categorys.size() < 5) {
            recommendOneDay(categoryGenerator);
        }
        return new MenuResult(categorys, coaches);
    }

    private void recommendOneDay(CategoryGenerator categoryGenerator) {
        Category category = Category.findCategory(categoryGenerator.generate());
        if (Collections.frequency(categorys, category) >= 2) {
            return;
        }
        for (Coach coach : coaches.getCoaches()) {
            addMenu(category, coach);
        }
        categorys.add(category);
    }

    private static void addMenu(Category category, Coach coach) {
        while (true) {
            String menu = Randoms.shuffle(category.getMenus().getNames()).get(0);
            if (coach.isRecommendPossible(menu)) {
               coach.addMenu(menu);
               break;
            }
        }
    }
}
