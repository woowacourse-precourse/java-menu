package menu.di;

import java.util.List;

public class RecommendResultDto {

    private final List<String> categories;
    private final List<List<String>> coachMenus;

    public RecommendResultDto(List<String> categories, List<List<String>> coachMenus) {
        this.categories = categories;
        this.coachMenus = coachMenus;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<List<String>> getCoachMenus() {
        return coachMenus;
    }
}
