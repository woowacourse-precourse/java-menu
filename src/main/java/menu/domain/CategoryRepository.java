package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryRepository {
    private CategoryRepository() {
    }

    private static final List<Category> categories = new ArrayList<>();

    public static List<Category> categories() {
        return Collections.unmodifiableList(categories);
    }

    public static void add(Category category) {
        categories.add(category);
    }

    public static Category findByName(String name) {
        return categories.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public static Category pickRandomCategory() {
        return categories.get(Randoms.pickNumberInRange(1, 5) - 1);
    }
}
