package menu.controller;

import menu.domain.Coach;

import java.util.List;

import static menu.option.Option.CATEGORIES;
import static menu.option.Option.WEEK;
import static menu.view.InputView.inputCantView;
import static menu.view.InputView.inputCoachesView;
import static menu.view.OutputView.*;

public class MainController {
    CoachController coachController = new CoachController();
    public void startRecommend(){
        startRecommendView();
        coachController.makeCoachList(inputCoachesView());
        inputCantEat();
        for(String week: WEEK){
            recommendMenu();
        }
        coachController.makeFoodList();
        printResult();
        endRecommendView();
    }
    private void printResult(){
        resultView();
        weekView();
        categoryView(coachController.getCategoryList());
        for(String coach: coachController.getCoachList()){
            printCoachMenu(coach);
        }
    }
    private void printCoachMenu(String coach){
        coachMenuView(coach,coachController.getCoaches().get(coach).getFoodList());
    }
    private void inputCantEat(){
        for(String coach:coachController.getCoachList()){
            coachController.makeCantEat(coach,inputCantView(coach));
        }
    }
    private void recommendMenu(){
        for(String coach:coachController.getCoachList()){
            coachController.recommendCategory(coach);
        }
    }
}
