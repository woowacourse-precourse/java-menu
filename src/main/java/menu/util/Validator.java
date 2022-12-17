package menu.util;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.MenuRecommender;
import menu.exception.CannotRecommendCategoryException;
import menu.exception.CannotRecommendMenuException;

public class Validator {

    private static final int MIN_COACHES_SIZE = 2;
    private static final int MAX_COACHES_SIZE = 5;

    private static final int MIN_COACH_NAME_SIZE = 2;
    private static final int MAX_COACH_NAME_SIZE = 4;

    private static final int MAX_BANNED_MENU_SIZE = 2;

    private static final int MAX_CATEGORY_SIZE = 2;

    public static void validateCoaches(List<Coach> coaches) {
        validateCoachSize(coaches.size());
        validateCoachNameSize(coaches);
        validateDuplicatedCoachesName(coaches);
    }

    private static void validateCoachSize(int coachSize) {
        if (coachSize < MIN_COACHES_SIZE | coachSize > MAX_COACHES_SIZE) {
            throw new IllegalArgumentException("[ERROR] 코치의 수는 2명 이상, 5명 이하입니다.");
        }
    }

    private static void validateCoachNameSize(List<Coach> coaches) {
        for (Coach coach : coaches) {
            int coachNameSize = coach.getName().length();

            if (coachNameSize < MIN_COACH_NAME_SIZE | coachNameSize > MAX_COACH_NAME_SIZE) {
                throw new IllegalArgumentException("[ERROR] 코치의 이름 길이는 2글자 이상 4글자 이하입니다.");
            }
        }
    }

    private static void validateDuplicatedCoachesName(List<Coach> coaches) {
        int originCoachSize = coaches.size();
        int coachSize = coaches.stream()
            .map(Coach::getName)
            .collect(Collectors.toSet())
            .size();

        if (originCoachSize != coachSize) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 중복되면 안됩니다.");
        }
    }

    public static void validateBannedMenus(List<String> bannedMenus, MenuRecommender menuRecommender) {
        if (bannedMenus.size() != 0) {
            validateExistedMenus(bannedMenus, menuRecommender);
        }
        validateMenuOverTwo(bannedMenus.size());
    }

    private static void validateExistedMenus(List<String> bannedMenus, MenuRecommender menuRecommender) {
        for (String bannedMenu : bannedMenus) {
            if (!menuRecommender.isExistedMenu(bannedMenu)) {
                throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴입니다.");
            }
        }
    }

    private static void validateMenuOverTwo(int menuSize) {
        if (menuSize > MAX_BANNED_MENU_SIZE) {
            throw new IllegalArgumentException("[ERROR] 먹지 못하는 음식은 두 개까지 등록 가능힙니다.");
        }
    }

    public static void validateCategories(Category category, List<Category> categories) {
        validateDuplicatedCategory(category, categories);
    }

    private static void validateDuplicatedCategory(Category category, List<Category> categories) {
        int duplicatedCount = 0;
        for (Category recommendCategory : categories) {
            if (category == recommendCategory) {
                duplicatedCount++;
            }
        }
        if (duplicatedCount >= MAX_CATEGORY_SIZE) {
            throw new CannotRecommendCategoryException();
        }
    }

    public static void validateRecommendMenus(List<String> recommendMenus) {
        validateDuplicatedMenus(recommendMenus);
    }

    private static void validateDuplicatedMenus(List<String> recommendMenus) {
        int originMenuSize = recommendMenus.size();
        int menuSize = new HashSet<>(recommendMenus)
            .size();

        if (originMenuSize != menuSize) {
            throw new CannotRecommendMenuException();
        }
    }
}
