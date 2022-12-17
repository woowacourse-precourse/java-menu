package menu.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Coaches {
    public static final int NUMBER_LOWER_BOUNDS = 2;
    public static final int NUMBER_UPPER_BOUNDS = 5;
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validate(coaches);
        this.coaches = coaches;
    }

    private void validate(List<Coach> coaches) {
        if (coaches.size() < NUMBER_LOWER_BOUNDS || coaches.size() > NUMBER_UPPER_BOUNDS) {
            throw new IllegalArgumentException("코치 명수 오류");
        }
    }

    public void receiveRecommendation(Menus allMenus, Category category, RecommendationMachine recommendationMachine) {
        coaches.stream()
                .forEach(coach -> coach.receiveRecommendation(allMenus, category, recommendationMachine));
    }

    public List<List<String>> getRecommendationResult() {
        return coaches.stream()
                .map(Coach::getRecommendationResult)
                .collect(Collectors.toUnmodifiableList());
    }
}
