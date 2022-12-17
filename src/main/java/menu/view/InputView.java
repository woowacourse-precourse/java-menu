package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.controller.dto.ExcludeMenuDto;
import menu.domain.Coaches;

public class InputView {

    public String inputCoach() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }

    public ExcludeMenuDto inputExcludeMenu(final Coaches coaches, final int count) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coaches.getCoachName(count));
        return new ExcludeMenuDto(coaches.getCoachName(count), Console.readLine());
    }
}
