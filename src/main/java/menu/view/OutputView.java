package menu.view;

import static menu.view.ViewConstants.*;

public class OutputView {
    public void showStartRecommender() {
        System.out.println(startLunchRecommenderMessage);
    }

    public void showRecommendResults() {
        System.out.println(showRecommendResultMessage);
        System.out.println(listOfDayMessage);
    }
}
