package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readName() {
        System.out.println("\n코치의 이름을 입력해 주세요. (, 로 구분)");

        return Console.readLine();
    }

    public String readCanNotEat(String name) {
        System.out.printf("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", name);

        return Console.readLine();
    }
}
