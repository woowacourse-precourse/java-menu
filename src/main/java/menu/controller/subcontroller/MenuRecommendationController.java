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
        for (int repeat = 0; repeat < Day.values().length; repeat++) {
            Category category = pickAvailableCategory();
            for (Coach coach : CoachRepository.coaches()) {
                Menu menu = pickAvailableMenu(coach, category);
                coach.addMenuAlreadyEaten(menu);
            }
            CategoryRepository.updateCategoriesAlreadyEaten(category);
        }
        outputView.printResult(CategoryRepository.getCategoriesAlreadyEaten(), CoachRepository.coaches());
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
        Menu menu = category.pickRandomMenuInCategory();
        if (!coach.isAvailableMenu(menu)) {
            return pickAvailableMenu(coach, category);
        }
        return menu;
    }
}
