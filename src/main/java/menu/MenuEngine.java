package menu;

import menu.view.InputView;

import java.util.List;

public class MenuEngine {

    public static void main(String[] args) {
        System.out.println("점심 메뉴 추천을 시작합니다.");

        InputView inputView = new InputView();

        List<String> coachNames = inputView.readCoachName();
    }
}
