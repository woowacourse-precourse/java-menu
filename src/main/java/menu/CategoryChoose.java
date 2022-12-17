package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.resource.Category;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CategoryChoose {
    private static int JAPAN  =1;
    private static int KOREA =2;
    private static int CHINESE = 3;
    private static int ASIAN =4;
    private static int FOREIGN = 5;
    private static int MAX_EAT = 2;
    private Map<Category,Integer> categoryCount = new LinkedHashMap<>();

    public CategoryChoose(){
        initiateCategory();
    }

    private void initiateCategory() {
        List<Category> categorys = List.of(Category.values());
        for(int i=0;i<categorys.size();i++){
            categoryCount.put(categorys.get(i),0);
        }
    }
    public Category getRandomCategory(){
        int categoryNumber = Randoms.pickNumberInRange(1,5);
        if(categoryNumber ==JAPAN){
            return checkNotMaxEat(Category.JAPAN);
        }
        if(categoryNumber ==KOREA){
            return checkNotMaxEat(Category.KOREA);
        }
        if(categoryNumber ==CHINESE){
            return checkNotMaxEat(Category.CHINESE);
        }
        if(categoryNumber == ASIAN){
            return checkNotMaxEat(Category.ASIAN);
        }
        return checkNotMaxEat(Category.FOREIGN);
    }

    private Category checkNotMaxEat(Category category) {
        if(categoryCount.get(category)<MAX_EAT){
            addCategoryCount(category);
            return category;
        }
        return null;
    }

    private void addCategoryCount(Category category) {
        categoryCount.put(category,categoryCount.get(category)+1);
    }
}
