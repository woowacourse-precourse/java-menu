package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.utils.CoachNameParser;
import menu.utils.FoodsInputParser;

import java.util.List;

import static java.text.MessageFormat.format;

public class InputView {
    private static final String COACH = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String DO_NOT_RECOMMEND = "{0}(이)가 못 먹는 메뉴를 입력해 주세요.";
    private final OutputView outputView = new OutputView();


    public List<String> getCoachNames() {
        System.out.println(COACH);
        String input = Console.readLine();

        return CoachNameParser.parseName(input);
    }

    public List<String> readDoNotRecommendFoodsOf(String name) {
        System.out.println(format(DO_NOT_RECOMMEND, name));
        String input = Console.readLine();

        return FoodsInputParser.parser(input);
    }
}
