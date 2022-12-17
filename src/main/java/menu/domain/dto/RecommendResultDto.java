package menu.domain.dto;

public class RecommendResultDto {

    private final String day;
    private final String category;
    private final String menu;

    public RecommendResultDto(String day, String category, String menu) {
        this.day = day;
        this.category = category;
        this.menu = menu;
    }

    public String getDay() {
        return day;
    }

    public String getCategory() {
        return category;
    }

    public String getMenu() {
        return menu;
    }
}
