package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MenuRecommendService {
    private final Categories categories = new Categories();
    private final List<Week> weeks = Week.getWeeks();
    List<Category> recommendCategories;
    private final List<Category> recommendedCategories = new ArrayList<>();

    public MenuRecommendService() {
        recommendCategory();
    }

    public void recommendCategory() {
        recommendCategories = categories.getRecommendCategory();
    }

    public void recommendMenu() {
        for (Category category :
                recommendedCategories) {
            recommendMenuEachPeople(category);
        }
    }

    private void recommendMenuEachPeople(Category category) {
        for (int i = 0; i < CouchRepository.couches().size(); i++) {
            String menu = Randoms.shuffle(category.getFoods()).get(0);
            if (CouchRepository.couches().get(i).getCannotEatFoods().contains(menu) || CouchRepository.couches().get(i).getRecommendedFoods().contains(menu)) {
                i--;
                continue;
            }
            CouchRepository.couches().get(i).addRecommendedFood(menu);
        }
    }
}
