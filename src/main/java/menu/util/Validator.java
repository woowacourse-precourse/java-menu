package menu.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final int MINIMUM_LENGTH = 2;
    private static final int MAXIMUN_LENGTH = 4;

    private static final int MINIMUM_NUMBER = 2;
    private static final int MAXIMUN_NUMBER = 5;

    private static final int NOT_EAT_FOOD_MINIMUM_NUMBER = 0;
    private static final int NOT_EAT_FOOD_MAXIMUM_NUMBER = 2;

    public static void validateCoach(String coachesByRest) {
        List<String> coaches = Arrays.asList(coachesByRest.split(",",-1));
        coaches.stream()
                .forEach(coachName -> validateCoachName(coachName));
        validateCoachNumber(coaches);
        validateDuplicateCoachName(coaches);
    }

    public static void validateNotEatFoods(String notEatFoods) {
        List<String> notEatFoodNames = Arrays.asList(notEatFoods.split(",",-1));
        validateNotEatFoodNumber(notEatFoodNames);
        validateDuplicateNotEatFoods(notEatFoodNames);
    }

    private static void validateCoachName(String name) {
        if (name.equals("") || name == null) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 공백일 수 없습니다.");
        }
        if (!(name.length() >= MINIMUM_LENGTH && name.length() <= MAXIMUN_LENGTH)) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자이여야 합니다.");
        }
    }

    private static void validateDuplicateCoachName(List<String> coachNames) {
        Set<String> distinct = new HashSet<>(coachNames);
        if (coachNames.size() != distinct.size()) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 중복될 수 없습니다.");
        }
    }

    private static void validateCoachNumber(List<String> coaches) {
        if (!(coaches.size() >= MINIMUM_NUMBER && coaches.size() <= MAXIMUN_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명까지 등록할 수 있습니다.");
        }
    }

    private static void validateNotEatFoodNumber(List<String> notEatFoods) {
        if (!(notEatFoods.size() >= NOT_EAT_FOOD_MINIMUM_NUMBER && notEatFoods.size() <= NOT_EAT_FOOD_MAXIMUM_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 음식은 최소 0개, 최대 2개여야 합니다.");
        }
    }

    private static void validateDuplicateNotEatFoods(List<String> notEatFoods) {
        Set<String> distinct = new HashSet<>(notEatFoods);
        if (notEatFoods.size() != distinct.size()) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 음식은 중복될 수 없습니다.");
        }
    }
}