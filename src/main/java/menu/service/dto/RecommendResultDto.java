package menu.service.dto;

import java.util.List;

public class RecommendResultDto {

    private final List<String> categories;
    private final List<List<String>> coachMenus;

    private RecommendResultDto(final List<String> categories, final List<List<String>> coachMenus) {
        this.categories = categories;
        this.coachMenus = coachMenus;
    }
    public static RecommendResultDto of(final List<String> categories, final List<List<String>> coachMenus){
        return new RecommendResultDto(categories, coachMenus);
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<List<String>> getCoachMenus() {
        return coachMenus;
    }
}