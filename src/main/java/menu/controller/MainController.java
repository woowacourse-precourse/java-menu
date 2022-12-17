package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.service.RecommendService;
import menu.utils.MenuInitiator;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RecommendService recommendService = new RecommendService();

    public <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(inputReader);
        }
    }

    public void run() {
        MenuInitiator.init();
        outputView.printStart();

        List<Coach> coaches = readCoaches();
        RecommendResult recommendResult = recommendService.recommend(coaches);
        outputView.printResult(recommendResult.getDays(), recommendResult.getCategories(),
            recommendResult.getEatFoods());
    }

    private List<Coach> readCoaches() {
        List<String> coachNames = repeat(inputView::readCoachNames);
        List<Coach> result = new ArrayList<>();
        for (String coachName : coachNames) {
            List<Menu> notEatMenus = getNotEatFoods(coachName).stream()
                .map(Menu::new)
                .collect(Collectors.toList());
            result.add(new Coach(coachName, notEatMenus));
        }
        return result;
    }

    private List<String> getNotEatFoods(String coachName) {
        try {
            return inputView.readNotEatFoods(coachName);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getNotEatFoods(coachName);
        }
    }
}
