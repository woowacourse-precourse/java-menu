package menu.controller;

import menu.controller.system.AbstractController;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.MenuRepository;
import menu.inputview.CoachInfoInputView;
import menu.outputview.CoachInfoOutputView;

import java.util.List;
import java.util.Map;

public class SavingBannedMenuPerCoachController extends AbstractController {
    @Override
    public void doProcess(Map<String, Object> model) {
        Coach coach = (Coach) model.get("coach");
        saveBannedMenus(coach);
    }

    private static void saveBannedMenus(Coach coach) {
        CoachInfoOutputView.printAskingMenuBanned(coach.getName());
        List<Menu> bannedMenus = CoachInfoInputView.getMenusBanned();
        MenuRepository.saveBannedMenu(coach, bannedMenus);
    }
}
