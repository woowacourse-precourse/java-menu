package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.dto.CoachNameDto;
import menu.dto.InvalidMenusDto;
import menu.dto.MenusDto;
import menu.service.CoachService;
import menu.service.MenuService;
import menu.util.Retry;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final MenuService menuService;
    private final CoachService coachService;

    public MenuController(MenuService menuService, CoachService coachService) {
        this.menuService = menuService;
        this.coachService = coachService;
    }

    public void run() {
        outputView.printStart();
        saveCoach();
        recommendMenu();
        outputView.printEnd();
    }

    private void saveCoach() {
        CoachNameDto coachNameDto = Retry.execute(inputView::readCoachNames);
        coachService.saveCoach(coachNameDto);
    }

    private void recommendMenu() {
        List<Coach> coaches = coachService.findAll();
        for (Coach coach : coaches) {
            InvalidMenusDto invalidMenusDto = Retry.execute(inputView::readMenuNames, coach.getName());
            coach.addInvalidMenus(invalidMenusDto.getMenus());
        }
        MenusDto result = menuService.recommendMenus(coaches);
        outputView.printMenuMessage(result);
    }
}
