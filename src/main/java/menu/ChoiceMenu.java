package menu;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Days;
import menu.domain.Menu;
import menu.domain.PickingCategory;
import menu.domain.PickingMenu;
import menu.domain.repository.CoachRepository;
import menu.service.SettingCoach;
import menu.service.SettingMenu;
import menu.view.InputView;
import menu.view.OutputView;

public class ChoiceMenu {

    OutputView output;
    InputView input;
    SettingMenu settingMenu;
    SettingCoach settingCoach;
    PickingCategory pickingCategory;
    PickingMenu pickingMenu;

    ChoiceMenu() {
        output = new OutputView();
        input = new InputView();
        settingMenu = new SettingMenu();
        settingCoach = new SettingCoach();
        pickingCategory = new PickingCategory();
        pickingMenu = new PickingMenu();
    }

    public void start() {
        settingMenu.setMenus();
        output.printServiceStart();

        setCoachs();
        setMenusToCoachs();
        getResult();
    }

    public void setCoachs() {
        String[] coachNames = getCoachNames();
        for (String coachName : coachNames) {
            settingCoach.addCoach(coachName);
            setCantEatMenusToCoach(coachName);
        }
    }

    public void setMenusToCoachs() {
        List<Coach> coachs = CoachRepository.getCoachs();
        for(int i=0; i< Days.values().length; i++) {
            setMenuToCoachs(coachs);
        }
    }

    public void setMenuToCoachs(List<Coach> coachs) {
        for (Coach coach : coachs) {
            setMenuToCoach(coach);
        }
    }

    public void setMenuToCoach(Coach coach) {
        Category category = getCategoryToCoach(coach);
        Menu menu = getMenuToCoach(coach, category);
        coach.addMenu(menu);
    }

    private Category getCategoryToCoach(Coach coach) {
        try {
            Category category = pickingCategory.getCategoryByPickingNumber();
            coach.isFineAboutCategory(category);
            return category;
        } catch (IllegalArgumentException e) {
            return getCategoryToCoach(coach);
        }
    }

    private Menu getMenuToCoach(Coach coach, Category category) {
        try {
            Menu menu = pickingMenu.getMenuByShuffle(category);
            coach.isNotDuplicateMenu(menu);
            return menu;
        } catch (IllegalArgumentException e) {
            return getMenuToCoach(coach, category);
        }
    }

    public void getResult() {
        List<Coach> coachs = CoachRepository.getCoachs();
        output.printResult();
        for (Coach coach : coachs) {
            output.printCoachMenus(coach.getName(), coach.getMenus());
        }
        output.printEnding();
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
