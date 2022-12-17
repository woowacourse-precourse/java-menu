package menu.domain;

import menu.domain.condition.CoachCondition;

public class Coach {
    private final String name;

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (CoachCondition.isWrongCoachName(name)) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 2글자 이상, 4글자 미만이어야 합니다.");
        }
    }
}
