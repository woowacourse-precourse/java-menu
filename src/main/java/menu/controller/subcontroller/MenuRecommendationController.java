package menu.controller.subcontroller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.Menu;
import menu.domain.repository.CategoryRepository;
import menu.domain.repository.CoachRepository;
import menu.domain.status.ApplicationStatus;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendationController implements Controllable {

    private final InputView inputView;
    private final OutputView outputView;

    public MenuRecommendationController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public ApplicationStatus process() {
        for (Day day : Day.values()) {
            Category category = pickAvailableCategory();
            for (Coach coach : CoachRepository.coaches()) {
                Menu menu = pickAvailableMenu(coach, category);
                coach.addMenuAlreadyEaten(day, menu);
            }
            CategoryRepository.addCategoryCount(category);
        }
        outputView.printRecommendedMenus(CategoryRepository.getCategoriesAlreadyEaten(), CoachRepository.coaches());
        outputView.printFinishRecommendation();
        return ApplicationStatus.APPLICATION_EXIT;
    }

    private Category pickAvailableCategory() {
        Category category = CategoryRepository.pickRandomCategory();
        if (!CategoryRepository.isAvailableCategory(category)) {
            return pickAvailableCategory();
        }
        return category;
    }

    private Menu pickAvailableMenu(Coach coach, Category category) {
        Menu menu = category.pickRandomMenu();
        if (!coach.isAvailableMenu(menu)) {
            return pickAvailableMenu(coach, category);
        }
        return menu;
    }
}
