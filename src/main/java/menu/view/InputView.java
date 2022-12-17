package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_NAMES = "\n코치의 이름을 입력해 주세요. (, 로 구분)";


    public String getNames() {
        System.out.println(INPUT_NAMES);
        return Console.readLine();
    }

    public String getHateFoods(String name) {
        String mention = String.format("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.", name);
        System.out.println(mention);
        return Console.readLine();
    }
}
