package menu.ui;

import menu.domain.Category;

public class InputViewValidation {

    private final String ERROR = "[ERROR] ";
    private final int MAX_COUCH = 5;
    private final int MIN_COUCH = 2;
    private final int MAX_COUCH_NAME = 5;
    private final int MIN_COUCH_NAME = 2;
    private final int MAX_FOOD = 2;

    private final String ERROR_COUCH_NUM = "코치는 최소 2명 이상 최대 5명 이하 입력해야 합니다.\n";
    private final String ERROR_COUCH_NAME_LENGTH = "코치의 이름은 최소 2글자 이상 최대 4글자 이하 입력해야합니다.\n";
    private final String ERROR_CANNOT_EAT_LENGTH = "못먹는 음식은 최소 0개 이상 최대 2개 이하 입력해야합니다.\n";
    private final String ERROR_MENU_NOT_EXIST = "입력하신 메뉴가 없습니다.\n";


    public void couchNumValidate(String input) {
        String[] couches = input.split(",");

        if (couches.length < MIN_COUCH || couches.length > MAX_COUCH) {
            throw new IllegalArgumentException(ERROR + ERROR_COUCH_NUM);
        }
    }

    public void couchNameValidate(String input) {
        String[] couches = input.split(",");
        for (String couch :
                couches) {
            if (couch.length() < MIN_COUCH_NAME || couch.length() > MAX_COUCH_NAME) {
                throw new IllegalArgumentException(ERROR + ERROR_COUCH_NAME_LENGTH);
            }
        }
    }

    public void couchCannotEatNumValidate(String input) {
        String[] foods = input.split(",");
        if (foods.length > MAX_FOOD) {
            throw new IllegalArgumentException(ERROR + ERROR_CANNOT_EAT_LENGTH);
        }
    }

    public void couchCannotEatFoodValidate(String input) {
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
