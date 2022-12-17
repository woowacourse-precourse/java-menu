package menu.controller;

import menu.domain.Coach;
import menu.domain.DayWeek;
import menu.service.CoachService;
import menu.service.InputService;
import menu.service.MenuService;
import menu.service.RecommendService;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static menu.constant.InputMessage.START_RECOMMEND;

public class RecommendController implements Controller {

    private final OutputView outputView = new OutputView();

    private final InputService inputService = new InputService();

    private final CoachService coachService = new CoachService();

    private final MenuService menuService = new MenuService();

    private final RecommendService recommendService = new RecommendService(menuService);

    public RecommendController() {
        MenuController menuController = new MenuController(menuService);
        menuController.process();
    }

    @Override
    public void process() {
        outputView.printMessage(START_RECOMMEND.getValue());
        List<String> coachNames = inputService.getUserInput(inputService::getCoachNames);
        List<Coach> coaches = getCoachNotEatFoods(coachNames);
        recommendByDayWeek(coaches);
        getRecommendResult(coaches);
    }

    private void getRecommendResult(List<Coach> coaches) {
        String recommendResult = recommendService.getRecommendResult(coaches);
        outputView.printRecommendResult(recommendResult);
    }

    private void recommendByDayWeek(List<Coach> coaches) {
        for (DayWeek dayWeek : DayWeek.values()) {
            recommendService.recommend(dayWeek, coaches);
        }
    }

    private List<Coach> getCoachNotEatFoods(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            List<String> notEatFoodNames = inputService.getUserInputWithParam(inputService::getNotEatFoods, coachName);
            Coach createdCoach = coachService.createCoachInfo(coachName, notEatFoodNames);
            coaches.add(createdCoach);
        }
        return coaches;
    }
}
