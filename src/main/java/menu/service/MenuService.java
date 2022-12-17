package menu.service;

import menu.domain.*;
import menu.dto.CoachDto;
import menu.dto.CoachesDto;
import menu.dto.RecommendationResultDto;
import menu.repository.MenuRepository;

import java.util.stream.Collectors;

public class MenuService {
    private Coaches coaches;
    private final RecommendationMachine recommendationMachine;

    public MenuService(RecommendationMachine recommendationMachine) {
        this.recommendationMachine = recommendationMachine;
    }

    public void registerCoaches(CoachesDto coachesDto) {
        coaches = coachesDto.getCoaches().stream()
                .map(coachDto -> toCoach(coachDto))
                .collect(Collectors.collectingAndThen(Collectors.toUnmodifiableList(), Coaches::new));
    }

    private static Coach toCoach(CoachDto coachDto) {
        return new Coach(coachDto.getCoachName(), MenuRepository.findMenus(coachDto.getNoEats()));
    }

    public RecommendationResultDto recommendMenus() {
        Day.inOrder().stream()
                .map(this::recommendCategory)
                .forEach(category -> recommendMenuForCoaches(category));
        return getRecommendationResult();
    }

    private Category recommendCategory(Day day) {
        Category category = recommendationMachine.category();
        day.setCategory(category);
        return category;
    }

    private void recommendMenuForCoaches(Category category) {
        coaches.receiveRecommendation(allMenus(), category, recommendationMachine);
    }

    private RecommendationResultDto getRecommendationResult() {
        return new RecommendationResultDto(Day.getCategoriesResult(),
                coaches.getRecommendationResult());
    }

    private Menus allMenus() {
        return MenuRepository.allMenus();
    }
}
