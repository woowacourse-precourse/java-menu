package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.Constant.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static menu.Constant.Menu.*;

public class Recommender {

    List<Coach> coaches;
    List<Menu> categories;

    Recommender(List<Coach> coaches){
        this.coaches = coaches;
        this.categories = new ArrayList<>();
        makeRandomCategories();
    }

    public List<Menu> getCategories() {
        return categories;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    private void makeRandomCategories(){
        List<Integer> randomCategory = new ArrayList<>();

        while(randomCategory.size() < 5){
            int category = Randoms.pickNumberInRange(1, 5);
            if(Collections.frequency(randomCategory, category) < 2){
                randomCategory.add(category);
                categories.add(matchCategory(category));
            }
        }
        //System.out.println(""+randomCategory);
    }

    private Menu matchCategory(int id){
        if(id == 1) return JAPANESE;
        if(id == 2) return KOREAN;
        if(id == 3) return CHINESE;
        if(id == 4) return ASIAN;
        if(id == 5) return WESTERN;
        return KOREAN;
    }

    public void startRecommend(){
        for(Menu todayCategory: categories){
            for(Coach coach: coaches) {
                recommendOneCoach(coach, todayCategory.getMenus());
            }
        }
    }

    public void recommendOneCoach(Coach coach, List<String> todayMenus){
        while(true){
            String curMenu = Randoms.shuffle(todayMenus).get(0);
            if(coach.isPossible(curMenu)){
                coach.addRecommend(curMenu);
                break;
            }
        }
    }
}
