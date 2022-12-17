package menu.ui;

import menu.domain.Category;

public class InputViewValidation {

    private final String ERROR = "[ERROR] ";
    private final int MAX_coach = 5;
    private final int MIN_coach = 2;
    private final int MAX_coach_NAME = 4;
    private final int MIN_coach_NAME = 2;
    private final int MAX_FOOD = 2;

    private final String ERROR_coach_NUM = "코치는 최소 2명 이상 최대 5명 이하 입력해야 합니다.\n";
    private final String ERROR_coach_NAME_LENGTH = "코치의 이름은 최소 2글자 이상 최대 4글자 이하 입력해야합니다.\n";
    private final String ERROR_CANNOT_EAT_LENGTH = "못먹는 음식은 최소 0개 이상 최대 2개 이하 입력해야합니다.\n";
    private final String ERROR_MENU_NOT_EXIST = "입력하신 메뉴가 없습니다.\n";


    public void coachNumValidate(String input) {
        String[] coaches = input.split(",");

        if (coaches.length < MIN_coach || coaches.length > MAX_coach) {
            throw new IllegalArgumentException(ERROR + ERROR_coach_NUM);
        }
    }

    public void coachNameValidate(String input) {
        String[] coaches = input.split(",");
        for (String coach :
                coaches) {
            if (coach.length() < MIN_coach_NAME || coach.length() > MAX_coach_NAME) {
                throw new IllegalArgumentException(ERROR + ERROR_coach_NAME_LENGTH);
            }
        }
    }

    public void coachCannotEatNumValidate(String input) {
        String[] foods = input.split(",");
        if (foods.length > MAX_FOOD) {
            throw new IllegalArgumentException(ERROR + ERROR_CANNOT_EAT_LENGTH);
        }
    }

    public void coachCannotEatFoodValidate(String input) {
        String[] foods = input.split(",");
        for (String food : foods) {
            if (food.length() == 0) continue;
            if (!isInCategory(food)) throw new IllegalArgumentException(ERROR + ERROR_MENU_NOT_EXIST);
        }
    }

    private boolean isInCategory(String food) {
        boolean check = false;
        for (Category category : Category.getCategories()) {
            if (category.getFoods().contains(food)) {
                check = true;
                break;
            }
        }
        return check;
    }

}
