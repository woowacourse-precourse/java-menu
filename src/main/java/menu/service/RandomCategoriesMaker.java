package menu.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomCategoriesMaker {
    public static final int START_RANDOM_NUMBER = 1;
    public static final int END_RANDOM_NUMBER = 5;
    public static final int LENGTH_CATEGORIES = 5;
    public static final String[] foodMenus = {"X", "일식", "한식", "중식", "아시안", "양식"};

    public static List<String> findRandomCategory() {
        while (true) {
            List<Integer> randomNumbers = makeRandomNumbers();
            List<String> randomCategories = new ArrayList<>();
            for (Integer randomNumber : randomNumbers) {
                randomCategories.add(foodMenus[randomNumber]);
            }
            if(checkAvailableCategoryCount(randomCategories)) {
                return randomCategories;
            }
        }
    }

    public static boolean checkAvailableCategoryCount(List<String> randomCategories) {
        Map<String, Integer> check = new HashMap<>();
        for (String category : randomCategories) {
            check.put(category, check.getOrDefault(category, 0) + 1);

            if (check.get(category) > 2) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> makeRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int count = 0; count < LENGTH_CATEGORIES; count++) {
            randomNumbers.add(makeRandomNumberForCategory());
        }

        return randomNumbers;
    }

    public static int makeRandomNumberForCategory() {
        return Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
    }
}
