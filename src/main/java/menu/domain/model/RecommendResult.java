package menu.domain.model;

public class RecommendResult {

    private final Day day;
    private final Category category;
    private final Menu menu;

    public RecommendResult(Day day, Category category, Menu menu) {
        this.day = day;
        this.category = category;
        this.menu = menu;
    }

    public boolean isEqualCategory(Category category) {
        System.out.println(this.category);
        return this.category.equals(category);
    }

    public boolean hasMenu(Menu menu) {
        return this.menu.equals(menu);
    }

    @Override
    public String toString() {
        return "RecommendResult{" +
                "day=" + day +
                ", category=" + category +
                ", menu=" + menu +
                '}';
    }

    public Day getDay() {
        return day;
    }

    public Category getCategory() {
        return category;
    }

    public String getMenu() {
        return menu.getName();
    }
}
