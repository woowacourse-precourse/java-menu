package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    private final List<String> categoryHistory = new ArrayList<>();
    private final List<Coach> coaches;

    private final int COACH_SIZE_LOWERBOUND = 2;
    private final int COACH_SIZE_UPPERBOUND = 5;

    public Group(List<Coach> coaches) {
        validateCoachSize(coaches);
        this.coaches = coaches;
    }

    private void validateCoachSize(List<Coach> coaches) {
        if (coaches.size() < COACH_SIZE_LOWERBOUND || coaches.size() > COACH_SIZE_UPPERBOUND) {
            throw new IllegalArgumentException("[ERROR] 코치 수는 2명에서 5명 사이여야 합니다.");
        }
    }

    public void addInedibleMenus(String coachName, List<String> menus) {
        coaches.stream()
                .filter(coach -> coach.getName().equals(coachName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("[ERROR] 해당되는 코치가 존재하지 않습니다."))
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
        } while (Collections.frequency(categoryHistory, categoryName) >= 2);
        categoryHistory.add(categoryName);
    }

    public MenuDTO getMenu() {
        return new MenuDTO(coaches, categoryHistory);
    }
}
