package menu;


import menu.domain.Coach;
import menu.domain.Menu;
import menu.repository.MenuRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuRecommendController {

    private final InputView inputView;
    private final OutputView outputView;

    public MenuRecommendController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        List<Coach> coaches = new ArrayList<>();

        String[] coachNames = inputView.readCoachNames();
        for (int i = 0; i < coachNames.length; i++) {
            String[] excludeMenu = inputView.readExcludeMenu(coachNames[i]);
            List<Menu> excludeMenus = new ArrayList<>();

            for (String menuName: excludeMenu) {
                excludeMenus.add(MenuRepository.getMenuByName(menuName));
            }
            coaches.add(new Coach(coachNames[i], excludeMenus));
        }

        System.out.println(coaches);
    }
}
