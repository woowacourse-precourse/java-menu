package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Coaches;
import domain.HateMenus;
import support.StringParser;

import java.io.IOException;

public final class InputView {
    private InputView() {}

    public static Coaches inputCoachNames() {
        return StringParser.parseStringToCoachesByRest(Console.readLine());
    }

    public static HateMenus inputHateMenus() throws IOException {
        return StringParser.parseStringToMenusByRest(Console.readLine());
    }
}
