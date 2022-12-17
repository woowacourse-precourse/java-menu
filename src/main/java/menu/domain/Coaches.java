package menu.domain;

import java.util.List;

public class Coaches {

    private final static int MIN_SIZE = 2;
    private final static int MAX_SIZE = 5;

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validate(coaches);
        this.coaches = coaches;
    }

    public void addLunchMenuToEachCoach(Category category) {
        coaches.forEach(coach -> coach.addLunchMenu(category));
    }


    private void validate(List<Coach> coaches) {
        if (coaches.size() < MIN_SIZE) {
            throw new IllegalArgumentException("코치는 최소 2명 이상 입력해야 합니다.");
        }

        if (coaches.size() > MAX_SIZE) {
            throw new IllegalArgumentException("코치는 최대 5명 입니다.");
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
