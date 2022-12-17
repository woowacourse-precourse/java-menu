package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    
    public List<String> readCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return toStringList(readInput());
    }
    
    private List<String> toStringList(String input) {
        String[] split = input.split(",");
        return new ArrayList<>(Arrays.asList(split));
    }
    
    private String readInput() {
        return Console.readLine();
    }
}
