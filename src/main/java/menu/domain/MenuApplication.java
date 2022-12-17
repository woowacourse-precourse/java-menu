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
        addEachCoachesHateMenu(coaches);
        List<Category> categories = recommendCategoryMaker.make();
        addCoachesLunchMenu(coaches, categories);
        outputView.printWeeklyRecommendMenu(CoachesWeeklyMenu.from(categories, coaches));
    }

    private void addEachCoachesHateMenu(Coaches coaches) {
        coaches.getCoaches()
                .forEach(coach -> {
                    List<Menu> menus = inputView.sendHateMenuBySpecificCoach(coach);
                    coach.addHateMenus(menus);
                });
    }

    private void addCoachesLunchMenu(Coaches coaches, List<Category> categories) {
        for (Category category : categories) {
            coaches.addLunchMenuToEachCoach(category);
        }
    }

}
