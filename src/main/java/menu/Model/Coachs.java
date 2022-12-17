package menu.Model;

import java.util.ArrayList;
import java.util.List;

public class Coachs {
    private List<Coach> coachs = new ArrayList<>();
    private final int MIN_NUM_COACH = 2;
    private final int MAX_NUM_COACH = 5;
    private final String COACHS_UNDER_RANGE = "코치는 최소 2명 이상 입력해야 합니다.";
    private final String COACHS_OVER_RANGE = "코치는 최대 5명 이하 입력해야 합니다.";

    public Coachs(String input) {
        List<String> names = List.of(input.split(","));
        this.validateCoachs(names);
        for (String name : names) {
            Coach coach = new Coach(name);
            this.coachs.add(coach);
        }
    }

    private void validateCoachs(List<String> names) {
        if (names.size() < MIN_NUM_COACH) {
            throw new IllegalStateException(COACHS_UNDER_RANGE);
        }
        if (names.size() > MAX_NUM_COACH) {
            throw new IllegalStateException(COACHS_OVER_RANGE);
        }
    }

    public List<Coach> getCoachs() {
        return this.coachs;
    }
}
