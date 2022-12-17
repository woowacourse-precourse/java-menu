package menu.domain;

public class RecommendResult {
    private final Coach coach;
    private final Menu menu;

    public RecommendResult(Coach coach, Menu menu) {
        this.coach = coach;
        this.menu = menu;
    }
}
