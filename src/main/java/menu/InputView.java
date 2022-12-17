package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String requestInputCoachName = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String requestInputNotEatMenuPostfix = "(이)가 못 먹는 메뉴를 입력해 주세요.";


    public List<String> readCoachName() {
        System.out.println(requestInputCoachName);
        String name = Console.readLine();
        List<String> coachList = Arrays.asList(name.split(","));
        return coachList;
    }

    public List<String> readNotEatMenu(String name) {
        System.out.println(name + requestInputNotEatMenuPostfix);
        String menuName = Console.readLine();
        List<String> notEatMenuList = Arrays.asList(menuName.split(","));
        return notEatMenuList;
    }

}
