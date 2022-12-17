package menu.controller;

import menu.model.Coach;
import menu.model.Menu;
import menu.service.CoachService;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class MenuRecommendController {
    private final CoachService coachService;
    private final MenuService menuService;

    public MenuRecommendController() {
        this.coachService = new CoachService();
        this.menuService = new MenuService();
    }

    public void startRecommend() {
        OutputView.printStartMessage();
        saveCoaches();
        OutputView.printResultMessage();
        // TODO: 추천한 메뉴 출력
        OutputView.printFinishMessage();
    }

    public void saveCoaches() {
        List<String> coachNames = this.readCoaches();
        for (String coachName : coachNames) {
            OutputView.printInputHateMenuMessage(coachName);
            List<Menu> hateMenus = InputView.readHateMenus().stream().map(menuService::findByName).collect(Collectors.toList());
            coachService.addCoach(coachName, hateMenus);
        }
    }

    public List<String> readCoaches() {
        OutputView.printCoachNameMessage();
        List<String> coachNames = new ArrayList<>();
        try {
            coachNames = InputView.readCoachNames();
        } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        coachNames = readCoaches();
        }
        return coachNames;
    }
}
