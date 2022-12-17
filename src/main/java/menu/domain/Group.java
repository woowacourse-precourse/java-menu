package menu.domain;

import java.util.List;

public class Group {
    private static final int MIN_SIZE = 2;
    private static final int MAX_SIZE = 5;
    private static final String INVALID_GROUP_SIZE = "함께 식사하는 코치의 수는 2~5명입니다.";
    private final List<Coach> group;

    public Group(List<Coach> group) {
        validate(group);
        this.group = group;
    }

    private void validate(List<Coach> group) {
        if (group.size() < MIN_SIZE || group.size() > MAX_SIZE) {
            throw new IllegalArgumentException(INVALID_GROUP_SIZE);
        }
    }


}
