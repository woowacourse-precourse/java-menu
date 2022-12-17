package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.List;

public class MenuController {

    public void startRecommend() throws IOException {
        //시작 알림 메시지
        OutputView.printStartRecommend();

        // 코치들 이름 입력 받는 부분
        Coaches coaches = inputCoachNames();

        // 각각의 코치가 못 먹는 메뉴 입력 받는 부분
        addCoachesHateMenu(coaches);

        MenuRecommender menuRecommender = new MenuRecommender(new CategoryDuplicationChecker(), new MenuDuplicatedChecker(), coaches);
        Result result = menuRecommender.generateRecommendResult();
        OutputView.printRecommendResult(result,coaches);
    }

    private Coaches inputCoachNames() {
        try {
            OutputView.printInputCoachNames();
            return InputView.inputCoachNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCoachNames();
        }
    }

    private void addCoachesHateMenu(Coaches coaches) {
        List<Coach> coachesName = coaches.getCoachesName();
        for (Coach coach : coachesName) {
            inputCoachHateMenu(coach);
        }
    }

    private void inputCoachHateMenu(Coach coach) {
        try {
            OutputView.printInputCoachHateMenu(coach);
            coach.addHateMenus(InputView.inputHateMenus());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputCoachHateMenu(coach);
        }
    }
}
