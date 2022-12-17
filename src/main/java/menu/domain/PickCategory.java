package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.utils.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickCategory {
    private final List<Category> categories;

    public PickCategory(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return Collections.unmodifiableList(categories);
    }

}
