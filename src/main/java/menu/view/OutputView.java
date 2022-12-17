package menu.view;

import menu.domain.DayWeek;

import static menu.constant.InputMessage.RECOMMEND_RESULT;
import static menu.constant.InputMessage.STOP_RECOMMEND;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printRecommendResult(String recommendResult) {
        System.out.println(RECOMMEND_RESULT.getValue());
        System.out.println(DayWeek.getDayWeekInfo());
        System.out.println(recommendResult);
        System.out.println(STOP_RECOMMEND.getValue());
    }
}
