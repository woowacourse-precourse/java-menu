package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.repository.CoachRepository;

public class MenuSelector {

    CoachRepository coachRepository = new CoachRepository();

    public List<Category> selectCategories(Coaches coaches) {
        coachRepository.setCoach(coaches);
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < Weekday.values().length; i++) {
            addRandomMenuByCategory(coaches, categories);
        }
        return categories;
    }

    private void addRandomMenuByCategory(Coaches coaches, List<Category> categories) {
        Category category = Category.randomCategory();
        categories.add(category);
        addCoachMenu(coaches, category);
    }

    private void addCoachMenu(Coaches coaches, Category category) {
        for (Coach coach : coaches.getCoaches()) {
            coachRepository.put(coach, category.randomMenuByCategory());
        }
    }

    public CoachMenus getMenusByCoach(Coach coach) {
        return coachRepository.get(coach);
    }
}
