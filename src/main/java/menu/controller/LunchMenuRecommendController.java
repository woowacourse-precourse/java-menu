package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class LunchMenuRecommendController {

    private InputView inputView;
    private OutputView outputView;

    private void init(){
        initView();
    }

    public void run(){

    }

    private void initView(){
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
    }

    private void initCoachInfo(){
        List<Coach> coaches = new ArrayList<>();
        for(String name: inputView.readCoachNames()){
            Coach coach = new Coach(name);
            coach.setBanFoods(inputView.readBanFoods(name));
            coaches.add(coach);
        }
    }
}
