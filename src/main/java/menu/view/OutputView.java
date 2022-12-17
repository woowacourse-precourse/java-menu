package menu.view;

import java.util.List;

import static menu.view.ViewConstants.*;

public class OutputView {
    public void showStartRecommender() {
        System.out.println(startLunchRecommenderMessage);
    }

    public void showRecommendResults() {
        System.out.println(showRecommendResultMessage);
        System.out.println(listOfDayMessage);
    }

    public void showRecommendedCategory(List<String> recommendedCategories) {
        String categoryMessage = String.join(" | ", recommendedCategories);
        System.out.println("[ 카테고리 | " + categoryMessage + " ]");
    }
}
