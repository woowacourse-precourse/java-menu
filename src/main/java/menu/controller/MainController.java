package menu.controller;

import menu.domain.Coach;

import static menu.option.Option.CATEGORIES;
import static menu.option.Option.WEEK;
import static menu.view.InputView.inputCantView;
import static menu.view.InputView.inputCoachesView;
import static menu.view.OutputView.endRecommendView;
import static menu.view.OutputView.startRecommendView;

public class MainController {
    CoachController coachController = new CoachController();
    public void startRecommend(){
        startRecommendView();
        coachController.makeCoachList(inputCoachesView());
        inputCantEat();
        for(String week: WEEK){
            recommendMenu();
        }
        endRecommendView();
    }
    private void inputCantEat(){
        for(String coach:coachController.getCoaches().keySet()){
            coachController.makeCantEat(coach,inputCantView(coach));
        }
    }
    private void recommendMenu(){
        for(String coach:coachController.getCoaches().keySet()){
            coachController.recommendFood(coach);
        }
    }
}
