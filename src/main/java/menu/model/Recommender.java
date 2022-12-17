package menu.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Recommender {

    Category category;
    List<Category> categoryCheckList = new ArrayList<>();
    
    public void recommendCategory() {
        do {
            category = Category.of(Randoms.pickNumberInRange(1, 5));
        } while (isTwiceDuplicated(category));
        categoryCheckList.add(category);
        System.out.println(categoryCheckList);
    }
    
    private boolean isTwiceDuplicated(Category category) {
        return categoryCheckList.stream().filter(checkedCategory -> checkedCategory == category).count() >= 2;
    }
}
