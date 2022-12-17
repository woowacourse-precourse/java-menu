package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCouchName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }
}
