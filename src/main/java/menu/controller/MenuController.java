package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.RandomFood;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.*;

public class MenuController {

    public static OutputView outputView = new OutputView();
    public static InputView inputView = new InputView();
    public static Food food = new Food();
    public static RandomFood randomFood = new RandomFood();
    public static Coach coach = new Coach();
    public static Map<Category,List<String>> foods = new HashMap<>();
    public static Map<String, List<String>> coachNotFoods = new HashMap<>();
    public static Map<String, List<String>> recommendFoods = new HashMap<>();

    public void start(){
        outputView.printStart();
        foods = food.initFoods();
        run();



    }
    public void run(){
        List<String> coaches = createCoach();
        coachNotFoods = createNotFoods(coaches);
        List<String> allCategory = randomFood.allCategory();
        recommendFoods = createRandomFoods(allCategory,coaches,coachNotFoods);
        outputView.printEnd(allCategory,recommendFoods);

    }

    public List<String> createCoach(){
        return inputView.inputCoach();
    }
    public Map<String,List<String>> createNotFoods(List<String> coaches){
        List<String> notFoods = new ArrayList<>();
        for(String coachName: coaches){
            notFoods = inputView.inputNotFood(coachName);
            coachNotFoods = coach.makeCoachInfo(coachName,notFoods);
        }
        return coachNotFoods;
    }
    public Map<String,List<String>> createRandomFoods(List<String> allCategory, List<String> coaches, Map<String,List<String>> notFoods){
        for(String coach: coaches){
            recommendFoods = randomFood.pickFoods(coach,foods,allCategory,notFoods);
        }
        return recommendFoods;
    }

}
