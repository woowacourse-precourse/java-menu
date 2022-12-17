package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.service.MenuSelector;
import menu.view.OutputView;

public class MenuSelectorController {

    public MenuSelectorController() {
        start();
    }

    private void start(){
        OutputView.printServiceStart();
        Coaches coaches = InputController.getCoaches();
        for (Coach coach : coaches.getCoaches()){
            List<String> prohibitedMenus = InputController.getProhibitedMenus(coach.getName());
            coach.addProhibitedMenus(prohibitedMenus);
        }
        MenuSelector.startWeek(coaches);
        OutputView.printFinalResult(coaches);
        OutputView.printServiceDone();
    }

}
