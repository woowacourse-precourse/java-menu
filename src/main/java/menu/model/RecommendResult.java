package menu.model;

import java.util.List;

public class RecommendResult {
    private CategoryResult categoryResult;
    private List<MenuResult> menuResults;

    public RecommendResult(CategoryResult categoryResult, List<MenuResult> menuResults) {
        this.categoryResult = categoryResult;
        this.menuResults = menuResults;
    }

    public List<MenuResult> getMenuResults() {
        return menuResults;
    }
}
