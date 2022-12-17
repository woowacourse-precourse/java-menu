package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
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

    public void start(){
        outputView.printStart();
        Map<Category,List<String>> foods = food.initFoods();
        System.out.println(foods);
        run();


    }
    public void run(){
        List<String> coaches = createCoach();
        createNotFoods(coaches);
        createRandomFoods();

    }

    public List<String> createCoach(){
        return inputView.inputCoach();
    }
    public void createNotFoods(List<String> coaches){
        List<String> notFoods = new ArrayList<>();
        for(String coach: coaches){
            notFoods = inputView.inputNotFood(coach);
            // 음식 카테고리 검색,
            food.splitNotFood(notFoods);

            // 음식 삭제
        }
    }
    public void createRandomFoods(){
        String category = randomFood.pickCategory();
    }



}
