package menu.businessLogic;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domains.Categories;

import java.util.ArrayList;
import java.util.List;

public class CategorySuggester {

    private final CategoryChecker checker = new CategoryChecker();

    public List<Categories> categorySuggest(){
        List<Categories> suggestedCategory = new ArrayList<>();
        for(int categoryIndex = 0; categoryIndex < 5;){
            Categories category = Categories.values()[Randoms.pickNumberInRange(1,5)-1];
            if(checker.checkAndAddSuggestedCategory(suggestedCategory,category)){
                categoryIndex++;
            }
        }
        return suggestedCategory;
    }
}
