package menu.domain;

import java.util.List;
import menu.dto.CoachesWeeklyMenu;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuApplication {

    private final InputView inputView;
    private final OutputView outputView;
    private final RecommendCategoryMaker recommendCategoryMaker;


    public MenuApplication(InputView inputView, OutputView outputView,
                           RecommendCategoryMaker recommendCategoryMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.recommendCategoryMaker = recommendCategoryMaker;
    }

    public void run() {
        outputView.printAppRunMessage();
        Coaches coaches = inputView.sendCoachNames();
        coaches.getCoaches()
                .forEach(coach -> {
                    List<Menu> menus = inputView.sendHateMenuBySpecificCoach(coach);
                    coach.addHateMenus(menus);
                });

        List<Category> categories = recommendCategoryMaker.make();
        addWeeklyMenuToEachCoach(coaches, categories);
        outputView.printWeeklyRecommendMenu(CoachesWeeklyMenu.from(categories, coaches));
    }

    private void addWeeklyMenuToEachCoach(Coaches coaches, List<Category> categories) {
        coaches.getCoaches()
                .forEach(coach -> {
                    for (Category category : categories) {
                        while (true) {
                            Menu randomMenuByCategory = Menu.createRandomMenuByCategory(category);
                            if (!coach.isHateMenu(randomMenuByCategory) || !coach.duplicateLunchMenu(randomMenuByCategory)) {
                                coach.addLunchMenu(randomMenuByCategory);
                                break;
                            }
                        }
                    }
                } );
    }
}
