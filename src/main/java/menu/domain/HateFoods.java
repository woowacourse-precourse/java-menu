package menu.domain;

import java.util.Arrays;
import java.util.List;

public class HateFoods {
    private final String INVALID_SIGN = "[ERROR] ,를 이용하여 이름을 구분하여 주세요";
    private final String INVALID_FOOD = "[ERROR] 메뉴에 있는 음식이름이 아닙니다.";
    private final String ONE_FORM = "^[가-힣]+$";
    private final String SEPARATOR = ",";
    private final String BLANK = "";
    private final int NONE_HATE_FOOD = 0;
    private final int ONE_HATE_FOOD = 1;
    private List<String> foods;

    public HateFoods(String foods) {
        validateForm(foods);
        if (foods.length() == NONE_HATE_FOOD) {
            this.foods = null;
        }
        if (foods.length() != NONE_HATE_FOOD) {
            this.foods = Arrays.asList(foods.split(SEPARATOR));
        }
    }

    private void validateForm(String foods) {
        validateSign(foods);
        List<String> target = Arrays.asList(foods.split(SEPARATOR));
        validateFoods(target);
    }

    private void validateSign(String foods) {
        if (foods.matches(ONE_FORM)) {
            return;
        }
        if (foods.length() != NONE_HATE_FOOD && !foods.contains(SEPARATOR)) {
            throw new IllegalArgumentException(INVALID_SIGN);
        }
    }

    private void validateFoods(List<String> target) {
        target.stream().
                forEach(name -> {
                    validateName(name);
                });
    }

    private void validateName(String name) {
        if (!Category.isInMenu(name) && !name.equals(BLANK)) {
            throw new IllegalArgumentException(INVALID_FOOD);
        }
    }

    public List<String> getFoods() {
        return this.foods;
    }
}
