package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;
import menu.model.Coach;

import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private final List<Category> pickedCategories = new ArrayList<>();

    public MenuService() {
        pickCategories();
    }

    private void pickCategories() {
        while (pickedCategories.size() < 5) {
            int order = Randoms.pickNumberInRange(1, 5);
            for (Category category : Category.values()) {
                addCategories(category, order);
            }

        }
    }

    private void addCategories(Category category, int order) {
        if (category.getOrder() == order && !checkCategoryPickedTwice(category)) {
            pickedCategories.add(category);
        }
    }

    private boolean checkCategoryPickedTwice(Category category) {
        int count = 0;
        for (Category pickedCategory : pickedCategories) {
            if (pickedCategory.equals(category)) {
                count++;
            }
        }
        return count == 2;
    }

    public void getMenus(List<Coach> coaches) {
        int idx = 0;
        while (idx < pickedCategories.size()) {
            for (Coach coach : coaches) {
                findMyMenu(coach, idx);
            }
            idx++;
        }
    }

    private void findMyMenu(Coach coach, int idx) {
        Category category = pickedCategories.get(idx);
        String menu = Randoms.shuffle(category.getMenus()).get(0);

        if (hasMenu(coach.getMyMenu(), menu) || hasMenu(coach.getNoMenu(), menu)) {
            findMyMenu(coach, idx);
        }
        coach.getMyMenu().add(menu);
    }

    private boolean hasMenu(List<String> coachMenu, String menu) {
        if (coachMenu.isEmpty()) {
            return false;
        }
        return coachMenu.contains(menu);
    }

    public List<String> getCategoryNames() {
        List<String> categoryName = new ArrayList<>();

        for (Category category : pickedCategories) {
            categoryName.add(category.getName());
        }

        return categoryName;
    }
}
