package menu;

import camp.nextstep.edu.missionutils.Console;

import javax.print.attribute.HashAttributeSet;
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
        String[] nameOfAllCoaches = Console.readLine().split(",");

        nameLengthValidate(nameOfAllCoaches);
        numberOfCoachesValidate(nameOfAllCoaches);

        return Arrays.stream(nameOfAllCoaches)
                .collect(Collectors.toList());
    }

    private void nameLengthValidate(String[] nameOfAllCoaches) {
        for (String name : nameOfAllCoaches) {
            if (!(2 <= name.length() && name.length() <= 4)) {
                throw new IllegalArgumentException(SystemConstant.ERROR + NAME_LENGTH_ERROR);
            }
        }
    }

    private void numberOfCoachesValidate(String[] nameOfAllCoaches) {
        if (!(2 <= nameOfAllCoaches.length && nameOfAllCoaches.length <= 5)) {
            throw new IllegalArgumentException(SystemConstant.ERROR + NUMBER_OF_COACHES_ERROR);
        }
    }

    public List<String> inputHateFood() {
        String[] hateFoods = Console.readLine().split(",");

        numberOfHateFoodValidate(hateFoods);
        hateFoodDuplicateValidate(hateFoods);
        foodExistValidate(hateFoods);

        return Arrays.stream(hateFoods).collect(Collectors.toList());
    }

    private void foodExistValidate(String[] hateFoods) {
        for (String food : hateFoods) {
            Category.foodValidate(food);
        }
    }

    private void numberOfHateFoodValidate(String[] hateFoods) {
        if (!(hateFoods.length <= 2)) {
            throw new IllegalArgumentException(SystemConstant.ERROR + NUMBER_OF_HATE_FOOD_ERROR)
        }
    }

    private void hateFoodDuplicateValidate(String[] hateFoods) {
        Set<String> duplicateChecker = new HashSet<>();

        for (String food : hateFoods) {
            duplicateChecker.add(food);
        }

        if (duplicateChecker.size() != hateFoods.length) {
            throw new IllegalArgumentException(SystemConstant.ERROR + DUPLICATE_HATE_FOOD);
        }
    }
}
