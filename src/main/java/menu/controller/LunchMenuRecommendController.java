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
        matchingLunch();
        printResult();
    }

    private void initView(){
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
    }

    private void initCoachInfo(){
        outputView.printStartMessage();
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

    private void matchingLunch(){
        this.lunchTable.matchingLunch();
    }

    private void printResult(){
        outputView.printRecommendInfo();
        outputView.printCategoryResult(lunchTable.getCategoriesName());

        for(Coach coach: lunchTable.getFoodsMatchingResult().keySet()){
            printCoachMatchingResult(coach, lunchTable.getFoodsMatchingResult().get(coach));
        }

        outputView.printGoodBye();
    }

    private void printCoachMatchingResult(Coach coach, List<String> foodMatchingResult){
        outputView.printRecommendResult(coach.getName(), foodMatchingResult);
    }
}
