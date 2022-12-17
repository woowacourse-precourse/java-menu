package menu.domain;

import static menu.domain.MenuRecommendatorConstants.COACHES_MAXIMUM_SIZE;
import static menu.domain.MenuRecommendatorConstants.COACHES_MINIMUM_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coaches {
    private static final String COACHES_MINIMUM_SIZE_ERROR = "코치는 최소 2명 이상 입력해야 합니다.";
    private static final String COACHES_MAXIMUM_SIZE_ERROR = "코치는 최대 5명 까지만 입력해야 합니다.";

    private final List<Coach> coaches = new ArrayList<>();

    public Coaches(List<String> coachNames) {
        validateCoachNames(coachNames);
        initCoaches(coachNames);
    }

    private void validateCoachNames(List<String> coachNames) {
        if (coachNames.size() < COACHES_MINIMUM_SIZE) {
            throw new IllegalArgumentException(COACHES_MINIMUM_SIZE_ERROR);
        }
        if (coachNames.size() > COACHES_MAXIMUM_SIZE) {
            throw new IllegalArgumentException(COACHES_MAXIMUM_SIZE_ERROR);
        }
    }

    public void initCoaches(List<String> coachNames) {
        for (String name : coachNames) {
            coaches.add(new Coach(name));
        }
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }
}
