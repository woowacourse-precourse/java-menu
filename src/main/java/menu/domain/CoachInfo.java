package menu.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class CoachInfo {
    private final Map<String, List<String>> coachForbiddenMenus;
    private final List<String> coachNames;

    private final int MIN_NAME_LENGTH = 2;
    private final int MAX_NAME_LENGTH = 4;

    private final int MIN_COACH_NUMBER = 2;
    private final int MAX_COACH_NUMBER = 5;

    private final int MAX_FORBIDDEN_MENU_COUNT = 2;

    public CoachInfo(List<String> coachNames) {
        validate(coachNames);
        this.coachNames = coachNames;
        coachForbiddenMenus = new HashMap<>();
    }

    public void initForbiddenFood(String coachName, List<String> menus) {
        validateForbiddenFoodCount(menus);
        validateDuplicationForbiddenFood(menus);
        for (String menu : menus) {
            CategoryMenu.validateMenuName(menu);
        }
        coachForbiddenMenus.put(coachName, menus);
    }

    public List<String> getCoachNames() {
        return coachNames;
    }

    public boolean isForbiddenMenu(String coachName, String menu) {
        return coachForbiddenMenus.get(coachName).contains(menu);
    }

    private void validate(List<String> coachNames) {
        validateCoachNumber(coachNames);
        for (String coachName : coachNames) {
            validateNameLength(coachName);
        }
        validateDuplicateName(coachNames);
    }

    private void validateNameLength(String coachName) {
        if (coachName.length() < MIN_NAME_LENGTH || coachName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(" 이름의 길이가 허용 범위 밖입니다.");
        }
    }

    private void validateCoachNumber(List<String> coachNames) {
        if (coachNames.size() < MIN_COACH_NUMBER || coachNames.size() > MAX_COACH_NUMBER) {
            throw new IllegalArgumentException(" 코치는 2~5명 사이만 가능합니다.");
        }
    }

    private void validateDuplicateName(List<String> coachNames) {
        if (new HashSet<>(coachNames).size() != coachNames.size()) {
            throw new IllegalArgumentException(" 코치 이름은 중복될 수 없습니다.");
        }
    }

    private void validateForbiddenFoodCount(List<String> menus) {
        if (menus.size() > MAX_FORBIDDEN_MENU_COUNT) {
            throw new IllegalArgumentException(" 못 먹는 음식은 최대 2개까지 가능합니다.");
        }
    }

    private void validateDuplicationForbiddenFood(List<String> menus) {
        if (menus.size() != new HashSet<>(menus).size()) {
            throw new IllegalArgumentException(" 못 먹는 음식 간 중복이 있습니다.");
        }
    }
}
