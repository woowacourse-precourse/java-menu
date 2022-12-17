package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.Category;

import java.util.List;

public class Recommender {
    
    public Category recommendCategory(){
        int randomNumber = Randoms.pickNumberInRange(1, 5);
        return Category.get(randomNumber-1);
    }

    public String recommendMenuOfCategory(Category category){
        List<String> shuffledMenus = Randoms.shuffle(category.getMenus());
        String menu = shuffledMenus.get(0);
        System.out.println(category.getName() + menu);
        System.out.println(shuffledMenus);
        return menu;
    }

}
