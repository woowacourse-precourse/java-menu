package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private final String DUPLICATE_HATE_FOOD = "이미 등록된 싫어하는 음식입니다.";
    private final String NUMBER_OF_COACHES_ERROR = "코치는 최소 2명, 최대 5명을 입력해야합니다.";
    private final String NAME_LENGTH_ERROR = "코치의 이름은 최소 2글자, 최대 4글자만 가능합니다.";
    private final String NUMBER_OF_HATE_FOOD_ERROR = "싫어하는 음식은 최소 0개, 2개 까지만 가능합니다";

    public List<String> inputNameOfCoaches() {
        List<String> nameOfAllCoaches = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        nameLengthValidate(nameOfAllCoaches);
        numberOfCoachesValidate(nameOfAllCoaches);
        System.out.println();

        return nameOfAllCoaches;
    }

    private void nameLengthValidate(List<String> nameOfAllCoaches) {
        for (String name : nameOfAllCoaches) {
            if (!(2 <= name.length() && name.length() <= 4)) {
                throw new IllegalArgumentException(SystemConstant.ERROR + NAME_LENGTH_ERROR);
            }
        }
    }

    private void numberOfCoachesValidate(List<String> nameOfAllCoaches) {
        if (!(2 <= nameOfAllCoaches.size() && nameOfAllCoaches.size() <= 5)) {
            throw new IllegalArgumentException(SystemConstant.ERROR + NUMBER_OF_COACHES_ERROR);
        }
    }

    public List<String> inputHateFood(Coach coach) { // 여기다가 출력문을 추가해도 될듯, 추후에 진짜로 만드는 과정에서 생각해보자.
        System.out.println(coach + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        List<String> hateFoods = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        numberOfHateFoodValidate(hateFoods);
        hateFoodDuplicateValidate(hateFoods);
        foodExistValidate(hateFoods);
        System.out.println();

        return hateFoods;
    }

    private void foodExistValidate(List<String> hateFoods) {
        for (String food : hateFoods) {
            Category.foodValidate(food);
        }
    }

    private void numberOfHateFoodValidate(List<String> hateFoods) {
        if (!(hateFoods.size() <= 2)) {
            throw new IllegalArgumentException(SystemConstant.ERROR + NUMBER_OF_HATE_FOOD_ERROR);
        }
    }

    private void hateFoodDuplicateValidate(List<String> hateFoods) {
        Set<String> duplicateChecker = new HashSet<>();

        for (String food : hateFoods) {
            duplicateChecker.add(food);
        }

        if (duplicateChecker.size() != hateFoods.size()) {
            throw new IllegalArgumentException(SystemConstant.ERROR + DUPLICATE_HATE_FOOD);
        }
    }
}
