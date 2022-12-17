package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    
    private static final String COACH_NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INEDIBLE_MENUS_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String REGEX = ",";
    
    public List<String> readCoachNames() {
        System.out.println(COACH_NAMES_MESSAGE);
        return toStringList(readInput());
    }
    
    public List<String> readInedibleMenus(String coachName) {
        System.out.println(coachName + INEDIBLE_MENUS_MESSAGE);
        return toStringList(readInput());
    }
    
    
    private List<String> toStringList(String input) {
        String[] split = input.split(REGEX);
        return new ArrayList<>(Arrays.asList(split));
    }
    
    private String readInput() {
        return Console.readLine();
    }
    
}
