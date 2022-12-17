package menu.controller;

import menu.domain.MenuMaker;
import menu.domain.MenuRecommendation;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class LunchMenuMachine {

    private final InputView inputView;
    private final OutputView outputView;
    private final MenuMaker menuMaker;

    public LunchMenuMachine(InputView inputView,
                            OutputView outputView, MenuMaker menuMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuMaker = menuMaker;
    }

    public void run() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");

        // 코치 입력
        String coachName = inputView.coachNameInput();
        List<String> coachNames = menuMaker.nameDivision(coachName);

        // 메뉴 입력
        String menu = inputView.menuInput();
        List<String> menus = menuMaker.menuDivision(menu);

        // 코치와 메뉴를 돌리기
        MenuRecommendation menuRecommendation = new MenuRecommendation;


    }
}
