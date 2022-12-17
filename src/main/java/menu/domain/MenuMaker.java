package menu.domain;

import menu.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuMaker {

    private final InputView inputView;

    public MenuMaker(InputView inputView) {
        this.inputView = inputView;
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
            System.out.println(coach + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            System.out.println();
            String menu = inputView.menuInput();
            coachMenu.put(coach, menu);
        }
        return coachMenu;
    }
}
