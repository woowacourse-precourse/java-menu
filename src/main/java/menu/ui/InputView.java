package menu.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_COUCH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private final String INPUT_CANNOT_EAT = "가 못 먹는 메뉴를 입력해 주세요.";

    InputViewValidation validation = new InputViewValidation();
    public String inputCouchNames() {
        System.out.println(INPUT_COUCH_NAMES);
        String input = Console.readLine();
        validation.couchNameValidate(input);
        validation.couchNumValidate(input);
        return input;
    }
}
