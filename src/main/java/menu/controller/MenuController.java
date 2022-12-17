package menu.controller;

import menu.domain.Menu;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class MenuController {
    private Map<String, List<String>> categoriesAndMenu;
    private List<String> coachName;
    private Map<String, List<String>> coachDislikeFood;

    private Menu menu;
    private InputView inputView;
    private OutputView outputView;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.menu = new Menu();
        this.categoriesAndMenu = menu.getMenu();
    }

    private void setCoachName() {
        outputView.printInputCoachNameMessage();
        coachName = inputView.readCoachName();
    }

    private void setCoachDislikeFood() {
        coachDislikeFood = inputView.readCoachDislikeFood(coachName);
    }

    public String pickTodayRandomCategory() {
        List<String> categories = categoriesAndMenu.keySet().stream().collect(Collectors.toList());
        String category = categories.get(Randoms.pickNumberInRange(0, 4));
        return category;
    }

    public String recommendRandomMenu(String category) {
        List<String> selectableMenu = categoriesAndMenu.get(category);
        String selectedMenu = Randoms.shuffle(selectableMenu).get(0);
        return selectedMenu;
    }
}
