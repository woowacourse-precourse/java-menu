package menu.exception;

import menu.domain.CategoryRepository;

public class MenuValidator {
    private static final String NUMBER_OF_MENU_ERROR_MESSAGE = "[ERROR] 메뉴는 0개 ~ 2개를 입력해야 합니다.";
    private static final String NONEXISTENT_FOOD_ERROR_MESSAGE = "[ERROR] 메뉴 추천 서비스에 없는 음식이 있습니다.";

    private static final String COMMA = ",";
    private static final int MAX_NUMBER_OF_MENU = 2;

    public static void validate(String source) {
        validateNumberOfMenu(source);
        validateExistFood(source);
    }

    public static void validateNumberOfMenu(String source) {
        String[] sourceSplitByComma = source.split(COMMA);
        if (sourceSplitByComma.length > MAX_NUMBER_OF_MENU && source.length() != 0) {
            throw new IllegalArgumentException(NUMBER_OF_MENU_ERROR_MESSAGE);
        }
    }

    public static void validateExistFood(String source) {
        if (source.length() == 0)
            return;

        String[] sourceSplitByComma = source.split(COMMA);

        for (String foodName : sourceSplitByComma) {
            if (!CategoryRepository.isExistFoodInAllCategories(foodName)) {
                throw new IllegalArgumentException(NONEXISTENT_FOOD_ERROR_MESSAGE);
            }
        }
    }
}
