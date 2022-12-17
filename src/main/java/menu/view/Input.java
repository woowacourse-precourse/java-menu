package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.ValidInputChecker;

import java.util.List;

public class Input {
    public static List<String> readCoachesName() {
        while(true){
            try{
                System.out.println("점심 메뉴 추천을 시작합니다.\n" +
                        "\n" +
                        "코치의 이름을 입력해 주세요. (, 로 구분)");
                return ValidInputChecker.validateCoachesAndToList(Console.readLine());
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<String> readInedibleFoods(String coachName) {
        while(true){
            try{
                System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
                return ValidInputChecker.validateNoFoodsAndToList(Console.readLine());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
