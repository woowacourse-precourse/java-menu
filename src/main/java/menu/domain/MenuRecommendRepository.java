package menu.domain;

import java.util.List;

public class MenuRecommendRepository {

    private static final List<String> categories = Food.getCategories();

    public void recommendCategory() {
        String recommendedCategory = Recommend.forCategory(categories);
        
        for (Coach coach : CoachRepository.coaches()) {
            coach.addMenu(Recommend.forMenu(Food.getMenuByCategory(recommendedCategory)));
        }
    }

}
