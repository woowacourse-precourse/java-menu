package exception;

import constant.Category;

import java.util.List;

public class FoodException {
    private static final int MAXIMUM_MENU_SIZE = 2;

    public static void validate(List<String> foodNames) {
        validateFoodNames(foodNames);
        validateFoodSize(foodNames);
    }

    private static void validateFoodNames(List<String> foodNames) {
        for (String name : foodNames) {
            if (!Category.hasMenu(name)) {
                throw new IllegalArgumentException("잘못된 메뉴입니다.");
            }
        }
    }

    private static void validateFoodSize(List<String> foodNames) {
        if (foodNames.size() > MAXIMUM_MENU_SIZE) {
            throw new IllegalArgumentException("메뉴는 최대 두 개 이상 입력할 수 없습니다.");
        }
    }
}
