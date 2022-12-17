package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void init() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public String readCoachesName() {
        System.out.println("\n코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }

    public String readCoachesAvoidance(String coachName) {
        System.out.println("\n" + coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        return Console.readLine();
    }
}
