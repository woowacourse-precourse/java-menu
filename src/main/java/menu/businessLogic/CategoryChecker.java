package menu.businessLogic;

import menu.domains.Categories;

import java.util.List;

public class CategoryChecker {
    public boolean checkAndAddSuggestedCategory(List<Categories> suggestedCategory, Categories category){
        if(suggestedCategory.size() == 0){
            suggestedCategory.add(category);
            return true;
        }
        if(checkThatCategoryCount(suggestedCategory,category) < 2){
            suggestedCategory.add(category);
            return true;
        }
        return false;
    }
    private int checkThatCategoryCount(List<Categories> suggestedCategory, Categories category){
        int count = 0;
        for (Categories existedCategory : suggestedCategory) {
            if (existedCategory.equals(category)) {
                count++;
            }
        }
        return count;
    }
}
