package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Menu;

public class InputView {

    public static List<String> readCoachNames() {
        OutPutView.printStartMessage();

        OutPutView.printRequestCoachNames();
        String input = Console.readLine();
        validateCoachNames(input);
        return Arrays.stream(input.split(",")).collect(Collectors.toList());
    }

    private static void validateCoachNames(String input) {
        if(input.split(",").length<2 || input.split(",").length >4){
            throw new IllegalArgumentException("코치는 최소 2명부터 4명까지가 최대입니다.");
        }
    }
//
    public static List<String> getCanNotEatMenus(String name) {
        OutPutView.printCatNotEatMenuEach(name);
        String input = Console.readLine();
        return Arrays.stream(input.split(",")).collect(Collectors.toList());
    }
}
