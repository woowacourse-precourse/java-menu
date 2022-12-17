package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    private final List<String> categoryHistory = new ArrayList<>();
    private final List<Coach> coaches;

    private final int COACH_SIZE_LOWERBOUND = 2;
    private final int COACH_SIZE_UPPERBOUND = 5;
    private final int CATEGORY_COUNT_LIMIT = 2;

    private final String COACH_SIZE_INVALID = String.format(
            "[ERROR] 코치 수는 %d명에서 %d명 사이여야 합니다.", COACH_SIZE_LOWERBOUND, COACH_SIZE_UPPERBOUND);
    private final String COACH_NOT_EXISTS = "[ERROR] 해당되는 코치가 존재하지 않습니다.";

    public Group(List<Coach> coaches) {
        validateCoachSize(coaches);
        this.coaches = coaches;
    }

    private void validateCoachSize(List<Coach> coaches) {
        if (coaches.size() < COACH_SIZE_LOWERBOUND || coaches.size() > COACH_SIZE_UPPERBOUND) {
            throw new IllegalArgumentException(COACH_SIZE_INVALID);
        }
    }

    public void addInedibleMenus(String coachName, List<String> menus) {
        coaches.stream()
                .filter(coach -> coach.getName().equals(coachName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(COACH_NOT_EXISTS))
                .addInedibleMenus(menus);
    }

    public void makeMenus() {
        for (int i = 0; i < 5; i++) {
            makeCategory();
            coaches.forEach(coach -> coach.addMenu(categoryHistory.get(categoryHistory.size() - 1)));
        }
    }

    private void makeCategory() {
        Category category = new Category();
        String categoryName;
        do {
            categoryName = category.getRandomCategory();
        } while (Collections.frequency(categoryHistory, categoryName) >= CATEGORY_COUNT_LIMIT);
        categoryHistory.add(categoryName);
    }

    public MenuDTO getMenu() {
        return new MenuDTO(coaches, categoryHistory);
    }
}
