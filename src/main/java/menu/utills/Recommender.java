package menu.utills;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Menu;
import menu.domain.MenuRepository;
import menu.utills.constants.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recommender {
    public static Category getRandomCategory() {
        int randomNumber = generateRandomNumber();
        return Category.getCategoryByValue(randomNumber);
    }

    public static Menu getRandomMenu(Category category) {
        List<String> menuNames = MenuRepository.getMenuNamesByCategory(category);
        String menuName = Recommender.getRandomMenuName(menuNames);
        return MenuRepository.getMenuByName(menuName);
    }

    public static String getRandomMenuName(List<String> menuNames) {
        return Randoms.shuffle(menuNames).get(0);
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(1, 5);
    }
}
