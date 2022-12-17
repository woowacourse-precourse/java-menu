package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recommender {

    List<Coach> coaches;
    List<Integer> categories;

    Recommender(List<Coach> coaches){
        this.coaches = coaches;
        this.categories = makeRandomCategories();
    }

    private List<Integer> makeRandomCategories(){
        List<Integer> randomCategory = new ArrayList<>();

        while(randomCategory.size() < 5){
            int category = Randoms.pickNumberInRange(1, 5);
            if(Collections.frequency(randomCategory, category) < 2){
                randomCategory.add(category);
            }
        }
        //System.out.println(""+randomCategory);
        return randomCategory;
    }

}
