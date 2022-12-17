package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.utils.CoachNameParser;

import java.util.List;

public class InputView {
    private static final String COACH = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private final OutputView outputView = new OutputView();


    public List<String> getCoachNames() {
        System.out.println(COACH);
        String input = Console.readLine();

        return CoachNameParser.parseName(input);
    }
}
