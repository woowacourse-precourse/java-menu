package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Coaches;
import support.StringParser;

public final class InputView {
    private InputView() {}

    public static Coaches inputCoachNames() {
        return StringParser.parseStringToCoachesByRest(Console.readLine());
    }
}
