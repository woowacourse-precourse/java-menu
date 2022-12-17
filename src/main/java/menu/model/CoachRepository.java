package menu.model;
import menu.enums.MenuOption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CoachRepository {

    private static final int MAX_DUPLICATION_ALLOWED_IN_CATEGORY = 2;
    private static final List<Coach> coaches = new ArrayList<>();
    private static final List<MenuOption> categories = new ArrayList<>();

    public static List<Coach> coaches() {
        return Collections.unmodifiableList(coaches);
    }

    public static List<MenuOption> categories() {
        return Collections.unmodifiableList(categories);
    }

    public static void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public static void addCategory(MenuOption menuOption) {
        if (canAddCategory(menuOption.getCategory())) {
            categories.add(menuOption);
        }
    }

    public static boolean canAddCategory(String category) {
        int categoryCount = (int) categories.stream()
                .filter(option -> Objects.equals(option.getCategory(), category))
                .count();

        return categoryCount < MAX_DUPLICATION_ALLOWED_IN_CATEGORY;
    }

    public static boolean canAddMenuInThisCategory(String menu, int day) {
        return categories.get(day).isContainsInCategroy(menu);
    }
}
