package menu.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommender {
    private static final int CAN_DUPLICATED_CATEGORY_COUNT = 2;
    private final Map<Coach, RecommendResult> result = new HashMap<>();
    private final Shuffler shuffler;

    public MenuRecommender(Shuffler shuffler) {
        this.shuffler = shuffler;
    }

    public void recommend(NumberGenerator numberGenerator, Group group) {
        initialRecommender(group);
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            Category category = selectCategory(numberGenerator);
            recommendMenu(group, dayOfWeek, category);
        }
    }

    private static Category selectCategory(NumberGenerator numberGenerator) {
        Category category;
        do {
            int generate = numberGenerator.generate(Category.MIN_CATEGORY_CODE, Category.MAX_CATEGORY_CODE);
            category = Category.from(generate);
        } while (category.getCount() > CAN_DUPLICATED_CATEGORY_COUNT);
        category.plusCount();
        return category;
    }

    private void initialRecommender(Group group) {
        result.clear();
        for (Coach coach : group.getGroup()) {
            result.put(coach, new RecommendResult());
        }
    }

    private void recommendMenu(Group group, DayOfWeek dayOfWeek, Category category) {
        List<String> menuNames = Menu.findByCategory(category);
        for (Coach coach : group.getGroup()) {
            RecommendResult recommendResult = result.get(coach);
            Menu recommendedMenu = selectMenu(coach, menuNames);
            while (recommendResult.containMenu(recommendedMenu)) {
                recommendedMenu = selectMenu(coach, menuNames);
            }
            recommendResult.putMenus(dayOfWeek, recommendedMenu);
            result.put(coach, recommendResult);
        }
    }

    private Menu selectMenu(Coach coach, List<String> menuNames) {
        List<String> menus = coach.exceptCantEatMenus(menuNames);
        return Menu.from(shuffler.shuffle(menus).get(0));
    }

    public Map<Coach, RecommendResult> getResult() {
        return result;
    }
}
