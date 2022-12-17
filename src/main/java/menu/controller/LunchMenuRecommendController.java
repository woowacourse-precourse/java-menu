package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import menu.domain.Categories;
import menu.domain.Coach;
import menu.domain.LunchTable;
import menu.view.InputView;
import menu.view.OutputView;

public class LunchMenuRecommendController {

    private InputView inputView;
    private OutputView outputView;
    private LunchTable lunchTable;

    private List<Coach> coaches;

    private void init(){
        initView();
        initCoachInfo();
        initLunchTable();
    }

    public void run(){
        init();
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
        this.coaches = coaches;
    }

    private void initLunchTable(){
        this.lunchTable = new LunchTable();
        initRandomCategory();
        lunchTable.setCoaches(coaches);
    }

    private void initRandomCategory(){
        while(!lunchTable.isCompleteCategories()){
            lunchTable.addCategory(Categories.get(Randoms.pickNumberInRange(1,5)));
        }
    }
}
