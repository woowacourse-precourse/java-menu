package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CategoryMaker {

    public static List<Category> makeCategories(){
        List<Category> categories = new ArrayList<>();
        while(true){
            int integer = Randoms.pickNumberInRange(1, 5);
            Category category = Category.indexToCategory(integer);
            long count = categories.stream().filter(s -> s == category).count();
            if(count > 1) continue;
            categories.add(category);
            if(categories.size() == 5) break;
        }
        return categories;
    }
}
