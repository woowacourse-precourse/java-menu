package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domains.Categories;

import java.util.ArrayList;
import java.util.List;

public class CategorySuggester {

    public List<Categories> categorySuggest(){
        List<Categories> suggestedCategory = new ArrayList<>();
        for(int categoryIndex = 0; categoryIndex < 5;){
            Categories category = Categories.values()[Randoms.pickNumberInRange(1,5)-1];
            if(checkAndAddSuggestedCategory(suggestedCategory,category)){
                categoryIndex++;
            };
        }
        return suggestedCategory;
    }
    private boolean checkAndAddSuggestedCategory(List<Categories> suggestedCategory, Categories category){
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
