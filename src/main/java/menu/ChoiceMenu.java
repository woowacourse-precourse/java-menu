package menu;

import java.util.List;
import menu.service.SettingCoach;
import menu.service.SettingMenu;
import menu.view.InputView;
import menu.view.OutputView;

public class ChoiceMenu {

    SettingMenu settingMenu;
    OutputView output;
    InputView input;
    SettingCoach settingCoach;

    ChoiceMenu() {
        settingMenu = new SettingMenu();
        output = new OutputView();
        input = new InputView();
        settingCoach = new SettingCoach();
    }

    public void start() {
        settingMenu.setMenus();
        output.printServiceStart();

        setCoachs();
        getResult();
    }

    public void setCoachs() {
        String[] coachNames = getCoachNames();
        for (String coachName : coachNames) {
            settingCoach.addCoach(coachName);
            setCantEatMenusToCoach(coachName);
        }
    }

    public void getResult() {
        output.printResult();
    }

    public String[] getCoachNames() {
        try {
            output.printGetCoachNames();
            return input.getCoachNames();
        } catch (IllegalArgumentException e) {
            output.printErrorMessage(e.getMessage());
            return getCoachNames();
        }
    }

    public List<String> getCantEatMenus(String coachName) {
        try {
            output.printGetCantEatMenus(coachName);
            String[] cantEatMenus = input.getCantEatMenus();
            return List.of(cantEatMenus);
        } catch (IllegalArgumentException e) {
            output.printErrorMessage(e.getMessage());
            return getCantEatMenus(coachName);
        }

    }

    public void setCantEatMenusToCoach(String coachName) {
        try {
            List<String> cantEatMenus = getCantEatMenus(coachName);
            settingCoach.addCoachCantEatMenus(coachName, cantEatMenus);
        } catch (IllegalArgumentException e) {
            output.printErrorMessage(e.getMessage());
            setCantEatMenusToCoach(coachName);
        }
    }
}
