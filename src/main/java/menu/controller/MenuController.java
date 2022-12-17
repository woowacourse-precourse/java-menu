package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.RandomFood;
import menu.view.InputView;
import menu.view.OutputView;

import java.lang.reflect.Array;
import java.util.*;

public class MenuController {

    public static OutputView outputView = new OutputView();
    public static InputView inputView = new InputView();
    public static Food food = new Food();
    public static RandomFood randomFood = new RandomFood();
    public static Coach coach = new Coach();
    public static Map<Category,List<String>> foods = new HashMap<>();
    public static Map<String, List<String>> coachNotFoods = new HashMap<>();

    public void start(){
        outputView.printStart();
        foods = food.initFoods();
        System.out.println(foods);
        run();


    }
    public void run(){
        List<String> coaches = createCoach();
        coachNotFoods = createNotFoods(coaches);
        createRandomFoods(coaches,coachNotFoods);

    }

    public List<String> createCoach(){
        return inputView.inputCoach();
    }
    public Map<String,List<String>> createNotFoods(List<String> coaches){
        List<String> notFoods = new ArrayList<>();
        for(String coachName: coaches){
            notFoods = inputView.inputNotFood(coachName);
            //food.splitNotFood(notFoods);

            // 코치별 싫은 음식
            coachNotFoods = coach.makeCoachInfo(coachName,notFoods);
        }
        return coachNotFoods;
    }
    public void createRandomFoods(List<String> coaches, Map<String,List<String>> notFoods){
        List<String> allCategory = randomFood.allCategory();
        System.out.println(allCategory.toString());
        for(String coach: coaches){
            randomFood.pickFoods(coach,foods,allCategory,notFoods);
        }
        System.out.println(randomFood.toString());
    }



}
