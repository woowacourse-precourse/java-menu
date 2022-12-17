package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.constants.Category;
import menu.domain.constants.DaysOfWeek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuService {
    private final List<Coach> coaches;
    private final List<Category> recommendCategoryOfDays = new ArrayList<>();

    public MenuService(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public void recommendMenu() {
        for (int i = 0; i < DaysOfWeek.COUNT; i++) {
            Category recommendCategory = getRecommendCategory(); //추천하고
            recommendCategoryOfDays.add(recommendCategory); //추가하기
            recommendMenuToCoaches(recommendCategory); // 각 코치들에게 메뉴 추천하기
        }
    }

    public Category getRecommendCategory() {
        Category recommendCategory;
        do {
            recommendCategory = getCategory();
        } while (!isPossibleCategoryToAdd(recommendCategory)); // 2개 이상 중복이면 다시

        return recommendCategory;
    }

    public Category getCategory() {
        int todayCategorySymbol = Randoms.pickNumberInRange(1, 5);
        return Category.getCategoriesBySymbol(todayCategorySymbol);
    }

    public void recommendMenuToCoaches(Category recommendCategory) {
        List<String> menu = Category.getMenusByCategory(recommendCategory);
        for (Coach coach : coaches) {
            coach.addMenuOfDaysWith(menu);
        }
    }

    // 유효성 검사
    public boolean isPossibleCategoryToAdd(Category todayCategory) {
        return Collections.frequency(recommendCategoryOfDays, todayCategory) < 2; //1개있을때까지만 추가 가능, 2부터는 추가 불가
    }

    //getter
    public List<String> getRecommendCategories() {
        List<String> recommendCategories = new ArrayList<>();
        recommendCategories.add(Category.START_CATEGORY);

        recommendCategoryOfDays
                .forEach(category -> recommendCategories.add(category.getName()));

        return recommendCategories;
    }

    public List<List<String>> getRecommendMenus() {
        List<List<String>> recommendMenus = new ArrayList<>();

        for (Coach coach : coaches) {
            List<String> recommendMenuOfCoach = coach.getRecommendMenuOfDays();
            recommendMenus.add(recommendMenuOfCoach);
        }
        return recommendMenus;
    }
}
