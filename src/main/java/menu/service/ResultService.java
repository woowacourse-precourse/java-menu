package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;

public class ResultService {
    public void pickCategory() {
        int randomNumber = Randoms.pickNumberInRange(1, 5);
        String categoryName = Category.convertNumberToName(randomNumber);
    }
}
