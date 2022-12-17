package menu.type;

import menu.menu.Category;

import java.util.Arrays;
import java.util.List;

public enum ValidationType {
    // 코치 인원 수, 이름 사이즈, 등록된 메뉴 여부, 메뉴 개수 체크
    CHECK_COACH_SIZE(Arrays.asList("2", "3", "4", "5"), ErrorMessage.COACH_SIZE_ERROR),
    CHECK_NAME_SIZE(Arrays.asList("2", "3", "4"), ErrorMessage.COACH_NAME_ERROR),
    CHECK_MENUS(Category.getAllMenus(), ErrorMessage.NONEXISTENT_MENU_ERROR),
    CHECK_MENUS_COUNT(Arrays.asList("0", "1", "2"), ErrorMessage.OVER_MENU_COUNT_ERROR);

    List<String> validationRange;
    ErrorMessage errorMessage;

    ValidationType(List<String> validationRange, ErrorMessage errorMessage) {
        this.validationRange = validationRange;
        this.errorMessage = errorMessage;
    }

    public List<String> getValidationRange() {
        return validationRange;
    }

    public static boolean validate(ValidationType validationType, String input) {
        return validationType.getValidationRange().contains(input);
    }

    public String getErrorMessage() {
        return errorMessage.getErrorMessage();
    }
}
