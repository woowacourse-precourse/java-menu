package menu.validation;

import menu.domain.Category;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CategoryValidation {

    public static Boolean checkWeekCategoryValid(Category category, List<Category> weekCategories) {
        int count = Collections.frequency(weekCategories, category);
        if (count == 2) {
            return false;
        }
        return true;
    }
}
