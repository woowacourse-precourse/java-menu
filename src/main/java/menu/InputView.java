package menu;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    InputValidation inputValidation = new InputValidation();

    public void initialization() {
        System.out.println(InputMessage.INITIALIZATION.get());
    }

    public String coachName() {
        System.out.println(InputMessage.COACH.get());
        String coachNames;
        do {
            coachNames = Console.readLine();
        } while (!inputValidation.handleNameException(coachNames));

        return coachNames;
    }

    public String coachInedibleMenu(String name) {
        System.out.println(name + InputMessage.INEDIBLE.get());
        String inedibleMenus;
        do {
            inedibleMenus = Console.readLine();
        } while (!inputValidation.handleInedibleException(inedibleMenus));

        return inedibleMenus;
    }
}

enum InputMessage {

    INITIALIZATION("점심 메뉴 추천을 시작합니다."),
    COACH("\n코치의 이름을 입력해 주세요. (, 로 구분)"),
    INEDIBLE("(이)가 못 먹는 메뉴를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}