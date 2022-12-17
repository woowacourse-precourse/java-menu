package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuRecommender {

    private static final String COACH_NAME_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 중복되는 코치의 이름이 입력되었습니다.";

    private List<Coach> coaches;

    public MenuRecommender() {
        coaches = new ArrayList<>();
    }

    public void addCoaches(List<String> coachNames) {
        for (String name : coachNames) {
            Coach coach = new Coach(name);
            validateCoach(coach);
            coaches.add(coach);
        }
    }

    private void validateCoach(Coach coach) {
        if (coaches.contains(coach)) {
            throw new IllegalArgumentException(COACH_NAME_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }
}
