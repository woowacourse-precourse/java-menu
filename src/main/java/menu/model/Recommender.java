package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.Category;

import java.util.List;

public class Recommender {
    private static final int MIN = 1;
    private static final int MAX = 5;
    
    public Category recommendCategory(){
        int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
        return Category.get(randomNumber-1);
    }

    public String recommendMenuOfCategory(Category category){
        List<String> shuffledMenus = Randoms.shuffle(category.getMenus());
        String menu = shuffledMenus.get(0);
        return menu;
    }

}
