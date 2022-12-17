package menu.view;

import java.util.List;

import static menu.view.ViewConstants.*;

public class OutputView {
    private String barDelimeter = " | ";
    public void showStartRecommender() {
        System.out.println(startLunchRecommenderMessage);
    }

    public void showRecommendResults() {
        System.out.println(showRecommendResultMessage);
        System.out.println(listOfDayMessage);
    }

    public void showRecommendedCategory(List<String> recommendedCategories) {
        String categoryMessage = String.join(barDelimeter, recommendedCategories);
        System.out.println("[ 카테고리 | " + categoryMessage + " ]");
    }

    public void showRecommendedMenu(String coachName, List<String> recommendedMenus) {
        String menuMessage = String.join(barDelimeter, recommendedMenus);
        System.out.println("[ " + coachName + barDelimeter + menuMessage + " ]");
    }

    public void showEndRecommender() {
        System.out.println(endLunchRecommenderMessage);
    }
}
