package menu.utills;

import camp.nextstep.edu.missionutils.Randoms;
import menu.utills.constants.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recommender {
    public static List<Category> getRandomCategory() {
        List<Integer> randomNumbers = generateRandomNumbers();
        return randomNumbers.stream()
                .map(Category::getCategoryByValue)
                .collect(Collectors.toList());
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 5) {
            int randomNumber = Randoms.pickNumberInRange(1,5);
            if(checkExistedDouble(randomNumbers, randomNumber)) {
                continue;
            }
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }

    private static boolean checkExistedDouble(List<Integer> numbers, int number) {
        int countDuplicated = (int) numbers.stream()
                .filter(integer -> integer == number)
                .count();
        return countDuplicated >= 2;
    }
}
