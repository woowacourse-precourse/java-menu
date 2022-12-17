package menu.service;

import menu.domain.*;
import menu.dto.NoEatsDto;
import menu.dto.RecommendationResultDto;
import menu.repository.MenuRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuService {
    private Coaches coaches;
    private RecommendationMachine recommendationMachine = new RecommendationMachine();

    public void registerCoaches(NoEatsDto noEatsDto) {
        coaches = noEatsDto.getNoEats().stream()
                .map(noEatDto -> new Coach(noEatDto.getCoachName(),
                        MenuRepository.findMenus(noEatDto.getNoEat())))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Coaches::new));
    }

    public RecommendationResultDto recommendMenus() {
        Day.inOrder().stream()
                .map(this::recommendCategory)
                .forEach(category ->
                        coaches.receiveRecommendation(allMenus(), category, recommendationMachine));
        return new RecommendationResultDto(Day.getCategories(),
                coaches.getRecommendationResult());
    }

    private Menus allMenus() {
        return MenuRepository.allMenus();
    }

    private Category recommendCategory(Day day) {
        Category category = recommendationMachine.category();
        day.setCategory(category);
        return category;
    }
}
