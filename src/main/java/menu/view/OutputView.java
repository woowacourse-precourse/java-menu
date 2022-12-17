package menu.view;

import java.util.List;

import static menu.view.ViewConstants.*;

public class OutputView {
    private final String BAR_DELIMITER = " | ";

    public void showStartRecommender() {
        System.out.println(startLunchRecommenderMessage);
    }

    public void showRecommendResults() {
        System.out.println(showRecommendResultMessage);
        System.out.println(listOfDayMessage);
    }

    public void showRecommendedCategory(List<String> recommendedCategories) {
        String categoryMessage = String.join(BAR_DELIMITER, recommendedCategories);
        System.out.println("[ 카테고리 | " + categoryMessage + " ]");
    }

    public void showRecommendedMenu(String coachName, List<String> recommendedMenus) {
        String menuMessage = String.join(BAR_DELIMITER, recommendedMenus);
        System.out.println("[ " + coachName + BAR_DELIMITER + menuMessage + " ]");
    }

    public void showEndRecommender() {
        System.out.println(endLunchRecommenderMessage);
    }
}
