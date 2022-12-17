package menu.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Recommender {

    Category category;
    List<Category> categoryCheckList = new ArrayList<>();
    
    public Category recommendCategory() {
        do {
            category = Category.of(Randoms.pickNumberInRange(1, 5));
        } while (isTwiceDuplicated(category));
        categoryCheckList.add(category);
        return category;
    }
    
    private boolean isTwiceDuplicated(Category category) {
        return categoryCheckList.stream().filter(checkedCategory -> checkedCategory == category).count() >= 2;
    }

    public String recommendFood(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }

    public List<Category> getCategoryCheckList() {
        return categoryCheckList;
    }
}
