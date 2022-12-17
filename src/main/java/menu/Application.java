package menu;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        List<String> coachName = inputView.readCoachName();
        List<Coach> coach = inputView.readDislikeFood(coachName);
        Category[] categories = Category.values();

        List<Integer> dailyCategory = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            while (true){
                int recommendCategory = RandomNumGenerator.makeCategoryNum();
                if (dailyCategory.stream().filter(num -> num == recommendCategory).count() < 2){
                    dailyCategory.add(recommendCategory);
                    break ;
                }
            }
            for (Coach eachCoach : coach){
                while (true){
                    Menu menu = new Menu(categories[i - 1].getMenuList());
                    if (eachCoach.isValidMenu(menu)){
                        break ;
                    }
                }
            }
        }



    }
}
