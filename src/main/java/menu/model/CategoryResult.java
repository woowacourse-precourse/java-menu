package menu.model;

import java.util.List;

public class CategoryResult {
    private List<String> categoryResult;

    public CategoryResult(List<String> categoryResult) {
        this.categoryResult = categoryResult;
    }

    public List<String> getCategoryResult() {
        return categoryResult;
    }
}
