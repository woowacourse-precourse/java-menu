package menu.controller;

import menu.domain.Coach;
import menu.domain.CoachName;
import menu.service.CoachService;
import menu.service.MenuService;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuController {
    private MenuService menuService = new MenuService();
    private CoachService coachService = new CoachService();
    private RecommendService recommendService = new RecommendService();
    public MenuController() {
        menuService.initMenus();
    }

    public void run() {
        OutputView.printStartMessage();
        List<Coach> coaches = readCoachNames();
        coaches.stream().forEach(coach -> readConNotEatMenus(coach));
        coachService.saveCoaches(coaches);
        recommendService.createWeeklyRecommendMenu();
    }

    private List<Coach> readCoachNames() {
        List<String> coachNames = InputView.readCoachName();
        return coachNames.stream()
                .map(CoachName::from)
                .map(name -> new Coach(name))
                .collect(Collectors.toList());
    }

    private Coach readConNotEatMenus(Coach coach) {
        try {
            List<String> menus = InputView.readCanNotEatMenu(coach.getName());
            checkMenu(menus);
            coach.addCanNotEatMenus(menus);
            return coach;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readConNotEatMenus(coach);
        }
    }

    private void checkMenu(List<String> menus) {
        if (menus.stream().allMatch(menu -> menuService.isExistsMenu(menu))) {
            throw new IllegalArgumentException("존재하지 않는 메뉴입니다.");
        }
    }
}
