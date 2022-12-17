package menu.controller;

import menu.IO.InputView;
import menu.IO.OutputView;
import menu.model.Category;
import menu.recommendation.MenuGenerator;
import menu.recommendation.RecommendationGenerator;

import java.util.ArrayList;
import java.util.List;

public class MenuRecommendationController {
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    final RecommendationGenerator recommendationGenerator = new RecommendationGenerator();
    final MenuGenerator menuGenerator = new MenuGenerator();
    public void run(){
        outputView.startMsg();
        outputView.promptReadCoachName();
        List<String> coaches = inputView.readCoachNames();
        List<Category> categories = recommendationGenerator.recommendCategory();
        List<List<String>> recommendedMenus = new ArrayList<>();
        List<List<String>> donEatMenus =new ArrayList<>();
        for (String coach: coaches){
            outputView.promptDontEatMenuCoach(coach);
            donEatMenus.add(inputView.readCoachDontEatMenus());
            recommendedMenus.add(new ArrayList<>());
        }

        for (int i = 0; i<5; i++){
            for (int j=0; j<coaches.size(); j++){
                List<String> userMenus = recommendedMenus.get(j);
                userMenus.add(menuGenerator.recommendMenu(userMenus, categories.get(i), donEatMenus.get(j)));
                recommendedMenus.set(j, userMenus);
            }
        }
        outputView.printResult(coaches, categories, recommendedMenus);
        outputView.endingMsg();
    }
}
