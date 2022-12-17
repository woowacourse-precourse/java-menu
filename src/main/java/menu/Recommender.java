package menu;

import java.util.ArrayList;
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
        return randomCategory;
    }

}
