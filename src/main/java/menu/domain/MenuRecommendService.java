package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.util.ListGenerator;
import menu.util.RandomNumberGenerator;

import java.util.List;

public class MenuRecommendService {
    private final Categories categories = new Categories(new RandomNumberGenerator());
    List<Category> recommendCategories;
    ListGenerator shuffledListGenerator;

    public MenuRecommendService(ListGenerator shuffledListGenerator) {
        this.shuffledListGenerator = shuffledListGenerator;
        recommendCategory();
    }

    private void recommendCategory() {
        recommendCategories = categories.getRecommendCategory();
    }

    public void recommendMenu() {
        for (Category category :
                recommendCategories) {
            recommendMenuEachPeople(category);
        }
    }

    private void recommendMenuEachPeople(Category category) {
        for (int i = 0; i < CoachRepository.coaches().size(); i++) {
            String menu = shuffledListGenerator.getShuffledList(category.getFoods()).get(0);
            if (CoachRepository.coaches().get(i).getCannotEatFoods().contains(menu) || CoachRepository.coaches().get(i).getRecommendedFoods().contains(menu)) {
                i--;
                continue;
            }
            CoachRepository.coaches().get(i).addRecommendedFood(menu);
        }
    }

    public List<Category> getRecommendedCategories() {
        return recommendCategories;
    }
}
