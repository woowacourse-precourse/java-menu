package menu.domain;


public class RecommendService {

    public static void selectCategory() {
        String recommendedCategory;

        do {
            recommendedCategory = RandomGenerator.forCategory(Food.getCategories());
        } while (!RecommendRepository.canRecommend(recommendedCategory));

        RecommendRepository.addCategory(recommendedCategory);
    }

    public static void selectMenu(String recommendedCategory) {
        String menu;

        for (Coach coach : CoachRepository.coaches()) {

            do {
                menu = RandomGenerator.forMenu(Food.getMenuByCategory(recommendedCategory));
            } while (coach.hasSameMenuRecommend(menu) || !coach.canEatMenu(menu));
            coach.addMenu(menu);
        }
    }


}
