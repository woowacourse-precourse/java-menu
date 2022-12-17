package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.Category;

import java.util.List;

public class Recommender {
    
    public Category recommendCategory(){
        int randomNumber = Randoms.pickNumberInRange(0, 4);
        return Category.get(randomNumber);
    }

    public String recommendMenuOfCategory(Category category){
        List<String> menus = category.getMenus();
        int max = menus.size() - 1;
        int randomNumber = Randoms.pickNumberInRange(0, max);
        String menu = menus.get(randomNumber);
        return menu;
    }

}
