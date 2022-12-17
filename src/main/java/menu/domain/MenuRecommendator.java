package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static menu.domain.MenuRecommendatorConstants.ALLOWED_DUPLICATED_CATEGORY_NUMBER;
import static menu.domain.MenuRecommendatorConstants.END_MENU_NUMBER;
import static menu.domain.MenuRecommendatorConstants.START_MENU_NUMBER;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRecommendator {

    private static final int FIRST_ELEMENT_INDEX = 0;


    private List<Category> categories = new ArrayList<>();

    public MenuRecommendator() {
        initCategories();
    }

    private void initCategories() {
        while (categories.size() < END_MENU_NUMBER) {
            Category selected = Category.fromInput(Randoms.pickNumberInRange(START_MENU_NUMBER, END_MENU_NUMBER));
            if (isOverDuplicatedCategory(selected)) {
                continue;
            }
            categories.add(selected);
        }
    }

    private boolean isOverDuplicatedCategory(Category newCategory) {
        return categories.stream().filter(category -> category.equals(newCategory))
                .count() >= ALLOWED_DUPLICATED_CATEGORY_NUMBER;
    }

    public void recommendMenu(Coaches coaches) {
        for (Category category : categories) {
            for (Coach coach : coaches.getCoaches()) {
                selectMenu(coach, category);
            }
        }
    }

    private void selectMenu(Coach coach, Category category) {
        while (true) {
            String menu = Randoms.shuffle(Menu.fromInput(category).getMenus()).get(FIRST_ELEMENT_INDEX);
            if (coach.addSelectedMenu(menu)) {
                break;
            }
        }
    }

    public List<String> getCategories() {
        return categories.stream()
                .map(Category::getCategoryName)
                .collect(Collectors.toList());
    }

}
