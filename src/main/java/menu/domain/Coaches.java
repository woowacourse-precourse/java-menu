package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches = new ArrayList<>();

    public Coaches(String coaches) {
        splitNames(coaches);
        if (!isValid(this.coaches.size())) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명입니다.");
        }
    }

    private boolean isValid(int size) {
        return 2 <= size && size <= 5;
    }

    private void splitNames(String coaches) {
        String[] splitNames = coaches.split(",");
        for (String splitName : splitNames) {
            Coach coach = new Coach(splitName);
            this.coaches.add(coach);
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
