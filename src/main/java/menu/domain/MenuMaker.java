package menu.domain;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuMaker {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuMaker(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<String> nameDivision(String coach) {
        List<String> coaches = new ArrayList<>();
        for (String person : coach.split(",")) {
            coaches.add(person);
        }
        return coaches;
    }

    public HashMap<String, String> menuDivision(List<String> coachNames) {
        HashMap<String, String> coachMenu = new HashMap<>();

        for (String coach : coachNames) {
            outputView.printNotMenuMessage(coach);
            String menu = inputView.menuInput();
            System.out.println();
            coachMenu.put(coach, menu);
        }
        return coachMenu;
    }
}
