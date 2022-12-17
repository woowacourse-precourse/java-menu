package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String INPUT_FOOD_NAME = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public List<String> inputCoach(){
        System.out.println(INPUT_COACH_NAME);
        String coach = Console.readLine();
        List<String> coaches = Arrays.asList(coach.split(","));
        return coaches;
    }
    public List<String> inputNotFood(String coachName){
        List<String> notFood = new ArrayList<>();
        System.out.printf(INPUT_FOOD_NAME,coachName);
        notFood = Arrays.asList(Console.readLine().split(","));
        return notFood;
    }

}
