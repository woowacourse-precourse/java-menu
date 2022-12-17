package menu.domain;

import java.util.List;

public class LunchTable {
    private static final int CATEGORY_SELECT_LIMIT = 2;
    private static final int MAX_CATEGORY_COUNT = 5;
    List<Categories> categories;

    public boolean isCompleteCategories(){
        return categories.size() == MAX_CATEGORY_COUNT;
    }

    public void addCategory(Categories category){
        if(!isOverCategorySelectLimit(category)){
            categories.add(category);
        }
    }

    private boolean isOverCategorySelectLimit(Categories category){
        return (CATEGORY_SELECT_LIMIT <= categories.stream()
                .filter(selectCategory -> selectCategory.equals(category)).count());
    }
}
