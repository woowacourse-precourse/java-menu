package menu.domain;

import java.util.List;
import java.util.stream.Collectors;
import menu.dto.response.CoachesWeeklyMenu;
import menu.dto.request.CoachNameDto;
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

        List<CoachNameDto> coachNameDtos = inputView.sendCoachNames();
        Coaches coaches = addEachCoachesHateMenu(coachNameDtos);
        List<Category> categories = recommendCategoryMaker.make();
        addCoachesLunchMenu(coaches, categories);
        outputView.printWeeklyRecommendMenu(CoachesWeeklyMenu.from(categories, coaches));
    }

    private Coaches addEachCoachesHateMenu(List<CoachNameDto> coachNameDtos) {
        return coachNameDtos.stream()
                .map(inputView::sendHateMenuBySpecificCoach)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Coaches::new));
    }

    private void addCoachesLunchMenu(Coaches coaches, List<Category> categories) {
        for (Category category : categories) {
            coaches.addLunchMenuToEachCoach(category);
        }
    }
}
