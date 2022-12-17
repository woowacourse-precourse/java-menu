package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputVIew {
    public static String getCoachNameInput() {
        System.out.println("\n코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }
}
