package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.coach.Coach;
import menu.domain.menucategory.MenuCategory;
import menu.repository.CoachRepository;
import menu.repository.MenuRepository;
import menu.repository.RecommendCategoryRepository;

import java.util.List;

public class CoachService {
    public void addCoaches(List<String> coachNames) {
        coachNames.stream()
                .map(Coach::from)
                .forEach(CoachRepository::addCoach);
    }

    public List<Coach> getAllCoaches() {
        return CoachRepository.getAllCoaches();
    }

    public void addDoNotRecommendFoods(Coach coach, List<String> foods) {
        foods.forEach(coach::addHateMenu);
    }

    private void recommendMenuTo(Coach coach, MenuCategory menuCategory) {
        List<String> menus = MenuRepository.getMenusOf(menuCategory);
        String menu = Randoms.shuffle(menus).get(0);

        if (!coach.canRecommend(menu)) {
            recommendMenuTo(coach, menuCategory);
        }
        coach.recommend(menu);
    }

    public void recommendMenus() {
        for (MenuCategory category : RecommendCategoryRepository.getMenuCategories()) {
            CoachRepository.getAllCoaches()
                    .forEach(coach -> recommendMenuTo(coach, category));
        }
    }
}
