package menu.domain;

import menu.dto.RecommendationResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validate(coaches);
        this.coaches = coaches;
    }

    private void validate(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
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
