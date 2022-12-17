package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuRecommender {

    private static final String COACH_NAME_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 중복되는 코치의 이름이 입력되었습니다.";

    private static final int MIN_COACH_NUMBER = 2;
    private static final int MAX_COACH_NUMBER = 5;

    private List<Coach> coaches;

    public MenuRecommender() {
        coaches = new ArrayList<>();
    }

    public void addCoaches(List<String> coachNames) {
        for (String name : coachNames) {
            addCoach(name);
        }
    }

    public void addCoach(String coachName) {
        try {
            Coach coach = new Coach(coachName);
            validateCoach(coach);
            coaches.add(coach);
        } catch (IllegalArgumentException exception) {
            initCoaches();
            throw exception;
        }
    }

    private void validateCoach(Coach coach) {
        if (coaches.contains(coach)) {
            initCoaches();
            throw new IllegalArgumentException(COACH_NAME_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private void initCoaches() {
        coaches = new ArrayList<>();
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public int getMinCoachNumber() {
        return MIN_COACH_NUMBER;
    }

    public int getMaxCoachNumber() {
        return MAX_COACH_NUMBER;
    }
}
