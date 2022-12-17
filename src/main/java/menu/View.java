package menu;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {
    public void startGame(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public List<String> inputCoachName(){
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        System.out.println(input);
        return List.of(input.split(","));
    }
}
