package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.utils.CoachNameParser;
import menu.utils.FoodsInputParser;

import java.util.List;

import static java.text.MessageFormat.format;

public class InputView {
    private static final String REQUEST_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String DO_NOT_RECOMMEND = "{0}(이)가 못 먹는 메뉴를 입력해 주세요.";

    public List<String> getCoachNames() {
        String input = getInput(REQUEST_COACH_NAMES);

        return CoachNameParser.parseName(input);
    }

    public List<String> readDoNotRecommendFoodsOf(String name) {
        String input = getInput(format(DO_NOT_RECOMMEND, name));

        return FoodsInputParser.parser(input);
    }

    private String getInput(String message) {
        System.out.println(message);

        return Console.readLine();
    }
}
