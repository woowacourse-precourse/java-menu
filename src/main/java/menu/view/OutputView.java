package menu.view;

import java.awt.datatransfer.FlavorListener;
import java.util.List;

import static menu.view.ViewConstants.*;

public class OutputView {
    private final String BAR_DELIMITER = " | ";

    public void showStartRecommender() {
        System.out.println(START_LUNCH_RECOMMENDER_MESSAGE);
    }

    public void showRecommendResults() {
        System.out.println(SHOW_RECOMMEND_RESULT_MESSAGE);
        System.out.println(LIST_OF_DAY_MESSAGE);
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
        System.out.println(END_LUNCH_RECOMMENDER_MESSAGE);
    }
}
