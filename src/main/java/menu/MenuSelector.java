package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class MenuSelector {
    private List<Integer> categoryRepository = new ArrayList<>();

    public int pickCategory() {
        int random = Randoms.pickNumberInRange(1, 5);
        if (checkAmount(random)) {
            return pickCategory();
        }
        return random;
    }

    private boolean checkAmount(int random) {
        int result = 0;
        for (Integer number : categoryRepository) {
            if (number == random) {
                result++;
            }
        }
        return result >= 2;
    }
}
