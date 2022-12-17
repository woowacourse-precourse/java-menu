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

    public void getMenus(Coach coach) {
        for (int i = 0; i < pickedCategories.size(); i++) {
            Category category = pickedCategories.get(i);
            String menu = Randoms.shuffle(category.getMenus()).get(0);

            if (hasMenu(coach.getMyMenu(), menu) || hasMenu(coach.getNoMenu(), menu)) {
                i--;
                continue;
            }
            coach.getMyMenu().add(menu);
        }
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
