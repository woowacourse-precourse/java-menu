package menu.utills;

import camp.nextstep.edu.missionutils.Randoms;
import menu.utills.constants.Category;

import java.util.List;

public class Recommender {
    public static Category getRandomCategory () {
        int randomNumber = generateRandomNumber();
        return Category.getCategoryByValue(randomNumber);
    }

    public static String getRandomMenuName(List<String> menuNames) {
        return Randoms.shuffle(menuNames).get(0);
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(1,5);
    }
}
