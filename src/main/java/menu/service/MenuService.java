package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Coach;
import menu.exception.InputException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MenuService {
    private final List<Coach> coaches = new ArrayList<>();
    private final List<Category> categories = new ArrayList<>();

    public List<Category> getCategories() {
        return categories;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void getCoachesName(String input) {
        validateCountOfCoaches(input);

        StringTokenizer st = new StringTokenizer(input, ",");
        while (st.hasMoreTokens())
            coaches.add(new Coach(st.nextToken()));
    }

    public void getAvoidance(List<String> inputs) {
        for (int i = 0; i < inputs.size(); i++)
            coaches.get(i).addAvoidance(inputs.get(i));
    }

    public void setCategories() {
        while (categories.size() < 5) {
            Category newCategory = Category.values()[Randoms.pickNumberInRange(0, 4)];
            addNewCategory(newCategory);
        }
    }

    public void setMenus() {
        for (int i = 0; i < 5; i++) {
            addMenu(categories.get(i).pickMenu());
        }
    }

    private void addMenu(String menu) {
        for (Coach coach : coaches){
            while(!coach.addRecommended(menu)){}
        }
    }

    private void addNewCategory(Category newCategory) {
        int count = 0;
        for (Category category : categories)
            if (category.equals(newCategory))
                count++;

        if (count < 2)
            categories.add(newCategory);
    }

    private void validateCountOfCoaches(String input) {
        StringTokenizer st = new StringTokenizer(input, ",");
        if (st.countTokens() < 2 || 5 < st.countTokens())
            throw new IllegalArgumentException(InputException.INVALID_COUNT_OF_COACHES.getMessage());
    }
}
