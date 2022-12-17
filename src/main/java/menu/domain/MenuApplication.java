package menu.domain;

import java.util.List;
import java.util.stream.Collectors;
import menu.dto.request.CoachesNameDto;
import menu.dto.request.HateMenuDto;
import menu.dto.response.CoachesWeeklyMenu;
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

        CoachesNameDto coachesNameDto = inputView.sendCoachNames();
        Coaches coaches = addEachCoachesHateMenu(coachesNameDto);
        List<Category> categories = recommendCategoryMaker.make();
        addCoachesLunchMenu(coaches, categories);

        outputView.printWeeklyRecommendMenu(CoachesWeeklyMenu.from(categories, coaches));
    }

    private Coaches addEachCoachesHateMenu(CoachesNameDto coachNameDtos) {
        return coachNameDtos.getNames()
                .stream()
                .map(coachNameDto -> {
                    HateMenuDto hateMenuDto = inputView.sendHateMenuBySpecificCoach(coachNameDto);
                    return new Coach(coachNameDto.getName(), hateMenuDto.getHateMenus());
                } )
                .collect(Collectors.collectingAndThen(Collectors.toList(), Coaches::new));
    }

    private void addCoachesLunchMenu(Coaches coaches, List<Category> categories) {
        for (Category category : categories) {
            coaches.addLunchMenuToEachCoach(category);
        }
    }
}
