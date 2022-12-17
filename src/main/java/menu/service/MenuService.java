package menu.service;

import java.util.List;
import java.util.stream.Collectors;
import menu.controller.dto.ExcludeMenuDto;
import menu.domain.Categories;
import menu.domain.Coach;
import menu.domain.CoachExcludeMenu;
import menu.domain.CoachRecommendMenu;
import menu.domain.Coaches;
import menu.domain.ExcludeMenu;
import menu.repository.CategoriesRepository;
import menu.repository.CoachRecommendMenuRepository;
import menu.repository.CoachesRepository;
import menu.repository.ExcludeMenuRepository;

public class MenuService {
    public Coaches saveCoach(final List<String> validatedCoach) {
        return CoachesRepository.save(validatedCoach.stream()
                .map(Coach::new)
                .collect(Collectors.toList()));
    }

    public void saveExcludeMenu(final ExcludeMenuDto inputExcludeMenu) {
        ExcludeMenuRepository.save(new CoachExcludeMenu(findCoach(inputExcludeMenu.getCoachName()),
                new ExcludeMenu(inputExcludeMenu.getMenus())));
    }

    private Coach findCoach(final String coachName) {
        return CoachesRepository.findByName(coachName);
    }

    public List<CoachRecommendMenu> recommendMenu() {
        return generateRecommendMenu(CategoriesRepository.generateCategories());

    }

    private List<CoachRecommendMenu> generateRecommendMenu(final Categories categories) {
        return CoachRecommendMenuRepository.generateMenusByCategories(
                categories,
                ExcludeMenuRepository.findAll());
    }

    public Categories findCategories() {
        return CategoriesRepository.find();
    }
}
