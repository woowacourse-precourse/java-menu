package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;

import java.util.List;

public class InputView {
    static final String GET_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)\n";
    static final String GET_HATE_MENU = "(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public static String getCoachInfo(){
        System.out.print(GET_COACH_NAME);
        return Console.readLine();
    }

    public static String getHateMenu(Coach coach){
        System.out.print(coach.getName()+GET_HATE_MENU);
        return Console.readLine();
    }
}
