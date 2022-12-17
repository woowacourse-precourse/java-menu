package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.CategoryNumberGenerator;
import menu.domain.CategoryRandomNumberGenerator;
import menu.domain.Coach;
import menu.domain.MatchingCategory;
import menu.view.InputView;

public class RecommendationController {

    public RecommendationController(){
        CategoryRegister.MenuListSave();
        startRecommendation();
    }

    public void startRecommendation(){
        List<String> coaches = new ArrayList<>();
        coaches = InputView.readCoachName();
        for (String coachName : coaches){
            List<String> dislikeMenus = new ArrayList<>();
            dislikeMenus = InputView.readDislikeMenu();
            Coach coach = new Coach(coachName, dislikeMenus);
            startmatching();
        }
    }

    private void startmatching(){
        CategoryNumberGenerator categoryNumberGenerator = new CategoryRandomNumberGenerator();
        MatchingCategory matchingCategory = new MatchingCategory(categoryNumberGenerator.generate());
        String Category = matchingCategory.getCategory();
    }
}
