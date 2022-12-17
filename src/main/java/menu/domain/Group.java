package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    private final List<String> categoryHistory = new ArrayList<>();
    private final List<Coach> coaches = new ArrayList<>();

    public void addCoach(CoachName name, List<String> cannotEatMenus) {
        coaches.add(new Coach(name, cannotEatMenus));
    }
//
//    private void validateCoachSize() {
//        // TODO: 입력 validator로 이동
//        if (coaches.size() < 2 || coaches.size() > 5) {
//            throw new IllegalArgumentException("[ERROR] 코치 수는 2명에서 5명 사이여야 합니다.");
//        }
//    }

    private void makeCategory() {
//        validateCoachSize();
        Category category = new Category();
        String categoryName;
        do {
            categoryName = category.getRandomCategory();
        } while (Collections.frequency(categoryHistory, categoryName) >= 2);
        categoryHistory.add(categoryName);
    }

    public void makeMenus() {
        for (int i = 0; i < 5; i++) {
            makeCategory();
            coaches.forEach(coach -> coach.addMenu(categoryHistory.get(categoryHistory.size() - 1)));
        }
    }

    public MenuDTO getMenu() {
        return new MenuDTO(coaches, categoryHistory);
    }
}
