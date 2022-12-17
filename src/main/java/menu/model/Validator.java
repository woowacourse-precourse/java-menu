package menu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static menu.view.ViewConstants.error;

public class Validator {
    private final static int MIN_COACH_NUMBER = 2;
    private final static int MAX_COACH_NUMBER = 5;
    private final static int MIN_NAME_LENGTH = 2;
    private final static int MAX_NAME_LENGTH = 4;
    private final static int MAX_DISLIKE_MENU = 2;
    private final static int MAX_DUPLICATE_CATEGORY = 2;

    public static List<String> isValidCoachesName(String userInput) {
        List<String> coachesName = new ArrayList<>(Arrays.asList(userInput.split(",")));
        isValidCoachesSize(coachesName);
        for (int index = 0; index < coachesName.size(); index++) {
            String realCoachName = coachesName.get(index).strip();
            coachesName.set(index, realCoachName);
        }
        isValidCoachName(coachesName);
        return coachesName;
    }

    private static void isValidCoachesSize(List<String> coachesName) {
        int numberOfCoach = coachesName.size();
        if (numberOfCoach < MIN_COACH_NUMBER) {
            throw new IllegalArgumentException(error + "코치는 최소 2명 이상 입력해야 합니다.");
        }
        if (numberOfCoach > MAX_COACH_NUMBER) {
            throw new IllegalArgumentException(error + "코치는 최대 5명까지 입력할 수 있습니다.");
        }
    }

    private static void isValidCoachName(List<String> coachesName) {
        for (String name : coachesName) {
            if (name.length() < MIN_NAME_LENGTH) {
                throw new IllegalArgumentException(error + "코치의 이름은 최소 2글자 이상 입력야 합니다.");
            }
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(error + "코치의 이름은 최대 4글자까지 입력할 수 있습니다.");
            }
        }
    }

    public static List<String> isValidDislikeMenus(String userInput) {
        List<String> dislikeMenus = new ArrayList<>(Arrays.asList(userInput.split(",")));
        isValidMenuSize(dislikeMenus);
        return dislikeMenus;
    }

    private static void isValidMenuSize(List<String> menus) {
        if (menus.size() > MAX_DISLIKE_MENU) {
            throw new IllegalArgumentException(error + "못 먹는 메뉴는 최대 2개까지만 입력해주세요.");
        }
    }

    public static boolean isValidCategory(Category category, List<Category> recommendedCategory) {
        if (Collections.frequency(recommendedCategory, category) < MAX_DUPLICATE_CATEGORY) {
            return true;
        }
        return false;
    }
}
