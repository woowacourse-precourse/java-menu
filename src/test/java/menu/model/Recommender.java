package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.Category;

public class Recommender {


    public Category recommendCategory(){
        int randomNumber = Randoms.pickNumberInRange(0, 4);
        return Category.get(randomNumber);
    }


}
