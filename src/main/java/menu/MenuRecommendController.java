package menu;


import menu.domain.Coach;
import menu.domain.WeekMenus;
import menu.domain.Menu;
import menu.enums.Category;
import menu.repository.MenuRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRecommendController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MenuRecommendService menuService = new MenuRecommendService();

    public MenuRecommendController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printStartMessage();
        List<Coach> coaches = initCoaches();
        List<Category> categories = CategoryPicker.pickMenuCategories();
        List<WeekMenus> menuResult = menuService.recommendMenus(coaches, categories);
        outputView.printMenuResult(categories.stream().map(Category::getName).collect(Collectors.toList()), menuResult.stream().map(WeekMenus::toDto).collect(Collectors.toList()));
        outputView.printFinishMessage();
    }

    private List<Coach> initCoaches() {
        List<Coach> coaches = new ArrayList<>();

        String[] coachNames = Validator.repeatUntilValid(InputView::readCoachNames);
        for (int i = 0; i < coachNames.length; i++) {
            String coachName = coachNames[i];
            String[] excludeMenu = Validator.repeatUntilValid(() -> inputView.readExcludeMenu(coachName));
            List<Menu> excludeMenus = new ArrayList<>();

            for (String menuName: excludeMenu) {
                excludeMenus.add(MenuRepository.getMenuByName(menuName));
            }
            coaches.add(new Coach(coachNames[i], excludeMenus));
        }
        return coaches;
    }
}
