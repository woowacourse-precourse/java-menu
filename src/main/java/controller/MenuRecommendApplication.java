package controller;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuRecommendApplication {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void start() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        List<String> coachNames = inputView.scanCoachNames();
        //System.out.println(coachNames);
    }
}
