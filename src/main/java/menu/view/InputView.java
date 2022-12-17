package menu.view;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> getCoachName() {
        System.out.println("점심 메뉴 추천을 시작합니다. \n\n 코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        return trimEachInput(Arrays.asList(input.split(",")));
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
