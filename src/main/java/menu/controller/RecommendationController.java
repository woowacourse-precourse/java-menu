package menu.controller;

import static menu.controller.CategoryRegister.getMenus;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.domain.CategoryNumberGenerator;
import menu.domain.CategoryRandomNumberGenerator;
import menu.domain.Coach;
import menu.domain.MatchingCategory;
import menu.domain.RecommendMenus;
import menu.view.InputView;

public class RecommendationController {

//    private List<Coach> coachs;

    public RecommendationController(){
        CategoryRegister.MenuListSave();
    }

    public void startRecommendation(){
        List<String> names = new ArrayList<>();
        List<Coach> coaches = new ArrayList<>();
        names = InputView.readCoachName();
        for (String coachName : names){
            List<String> dislikeMenus = new ArrayList<>(InputView.readDislikeMenu(coachName));
            Coach coach = new Coach(coachName, dislikeMenus);
            coaches.add(coach);
        }
//        System.out.println(coaches);
        runRecommendation(coaches);
    }

    private void runRecommendation( List<Coach> coaches){
        CategoryNumberGenerator categoryNumberGenerator = new CategoryRandomNumberGenerator();
        for (int i=0; i<5; i++){
            MatchingCategory matchingCategory = new MatchingCategory(categoryNumberGenerator.generate());
            String Category = matchingCategory.getCategory();
            System.out.println(Category);
            addRecommendResult(coaches, Category);
        }
    }

    private void addRecommendResult(List<Coach> coaches,String Category){
        String recommendMenu = matchingMenu(Category);
        for(Coach coach : coaches){
            coach.setRecommendMenus(recommendMenu);
        }
    }

    private String matchingMenu(String Category){
        List<String> menus = getMenus(Category);
        String menu = Randoms.shuffle(menus).get(0);
        return menu;
    }


}
