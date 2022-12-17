package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuSelector {
    private List<String> categoryRepository = new ArrayList<>();

    public String pickCategory() {
        int random = Randoms.pickNumberInRange(1, 5);
        Dish dish = Arrays.stream(Dish.values()).filter(s -> s.number == random)
                .findFirst().get();
        if (checkAmount(dish)) {
            return pickCategory();
        }
        categoryRepository.add(dish.name);
        return dish.name;
    }

    private boolean checkAmount(Dish dish) {
        int result = 0;
        for (String menu : categoryRepository) {
            if (dish.name.equals(menu)) {
                result++;
            }
        }
        return result >= 2;
    }
}
