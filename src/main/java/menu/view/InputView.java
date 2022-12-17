package menu.view;


import camp.nextstep.edu.missionutils.Console;
import menu.Constant;
import menu.vo.Coach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> getCoachName() {
        System.out.println("점심 메뉴 추천을 시작합니다. \n\n 코치의 이름을 입력해 주세요. (, 로 구분)");
        return trimEachInput(splitInput(Console.readLine()));
    }

    public List<Coach> getCoachNotEat(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : coachNames) {
            System.out.printf(Constant.inputNotEatFood,name);
            List<String> notEatFoods = trimEachInput(splitInput(Console.readLine()));
            coaches.add(new Coach(name,notEatFoods));
        }
        return coaches;
    }

    // 입력값을 "," 단위로 분해
    private List<String> splitInput(String input) {
        return Arrays.asList(input.split(","));
    }

    // 입력값 각각을 trim
    private List<String> trimEachInput(List<String> inputs) {
        List<String> returnWords = new ArrayList<>();
        for(String word : inputs) {
            returnWords.add(word.trim());
        }
        return returnWords;
    }

}
