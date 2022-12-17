package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuSelector {
    private static final int MENU_MIN = 1;
    private static final int MENU_MAX = 5;
    private static final int WEEK_MAX = 2;
    private static final int ZERO = 0;


    private List<String> categoryRepository = new ArrayList<>();

    public String pickCategory() {
        int random = Randoms.pickNumberInRange(MENU_MIN, MENU_MAX);
        Dish dish = Arrays.stream(Dish.values()).filter(s -> s.number == random)
                .findFirst().get();
        if (checkAmount(dish)) {
            return pickCategory();
        }
        categoryRepository.add(dish.name);
        return dish.name;
    }

    private boolean checkAmount(Dish dish) {
        int result = ZERO;
        for (String menu : categoryRepository) {
            if (dish.name.equals(menu)) {
                result++;
            }
        }
        return result >= WEEK_MAX;
    }

    public List<String> getCategoryRepository() {
        return categoryRepository;
    }
}
