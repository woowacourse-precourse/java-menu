package menu.view;

import menu.domain.Coach;

public class InputView {

    public void coachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void cantEat(Coach coach) {
        System.out.println(coach.getName() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }
}
