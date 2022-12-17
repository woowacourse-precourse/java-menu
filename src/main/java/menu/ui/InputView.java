package menu.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PUT_COACHES_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static String readCoachesName() {
        System.out.println(PUT_COACHES_NAME);
        return Console.readLine();
    }
}
