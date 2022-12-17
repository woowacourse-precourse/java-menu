package menu;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<List<String>> coaches = new ArrayList<>();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameProcess();
    }
    public static void GameProcess() {
        GetName();
        System.out.println(coaches);
    }

    public static void GetName(){
        List<String> coachNames = new ArrayList();
        String name = Console.readLine();
        String[] cNames = name.split(",");
        for (int i = 0; i < cNames.length; i++) {
            coachNames.add(cNames[i].trim());
        }
        System.out.println("coach name:"+coachNames);
        for (int i = 0; i < coachNames.size(); i++) {
            coaches.add(NoFood(coachNames.get(i)));
        }
    }

    public static List NoFood(String name){
        List<String> food = new ArrayList<>();
        food.add(name);
        String foodName = Console.readLine();
        String[] foods = foodName.split(",");
        for (int i = 0; i < foods.length; i++) {
            food.add(foods[i].trim());
        }
        return food;
    }
}
