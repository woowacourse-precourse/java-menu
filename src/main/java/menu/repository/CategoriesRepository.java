package menu.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Categories;
import menu.domain.enums.Category;

public class CategoriesRepository {
    public static final int CATEGORIES_INDEX = 0;
    private static final CategoriesRepository instance = new CategoriesRepository();
    private static final List<Categories> store = new ArrayList<>();

    private CategoriesRepository() {
    }

    public static Categories generateCategories() {
        List<Category> categories = new ArrayList<>();
        while (true) {
            int day = Randoms.pickNumberInRange(1, 5);
            if (getCount(categories, day) < 2) {
                categories.add(Category.get(day));
            }
            if (categories.size() == 5) {
                break;
            }
        }
        return save(new Categories(categories));
    }

    private static Categories save(final Categories categories) {
        delete();
        store.add(categories);
        return find();
    }

    public static Categories find() {
        return store.get(CATEGORIES_INDEX);
    }

    private static void delete() {
        store.clear();
    }

    private static int getCount(final List<Category> categories, final int day) {
        return (int) categories.stream()
                .filter(category -> category.contains(day))
                .count();
    }
}
