package menu.domain.results;

import java.util.List;

public class RecommendResult {
    private final RecommendCategories recommendCategories;
    private final List<RecommendCoachMenu> recommendCoachMenu;

    private RecommendResult(RecommendCategories recommendCategories, List<RecommendCoachMenu> recommendCoachMenu) {
        this.recommendCategories = recommendCategories;
        this.recommendCoachMenu = recommendCoachMenu;
    }

    public static RecommendResult of(RecommendCategories recommendCategories, List<RecommendCoachMenu> recommendCoachMenu) {
        return new RecommendResult(recommendCategories, recommendCoachMenu);
    }

    public String categoryFormat() {
        return recommendCategories.resultFormat();
    }

    public String coachMenusFormat() {
        StringBuilder coachMenusFormat = new StringBuilder();
        for (RecommendCoachMenu coachMenu : recommendCoachMenu) {
            coachMenusFormat.append(coachMenu.resultFormat()).append("\n");
        }

        return coachMenusFormat.toString();
    }
}
