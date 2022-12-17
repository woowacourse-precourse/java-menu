package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import menu.controller.dto.ExcludeMenuDto;
import menu.domain.Coach;
import menu.domain.Coaches;

public class InputView {

    public String inputCoach() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }

    public List<ExcludeMenuDto> inputExcludeMenu(final Coaches coaches) {
        List<ExcludeMenuDto> menuDtos = new ArrayList<>();
        coaches.getCoachList()
                .stream()
                .map(Coach::getName)
                .forEach(name -> {
                    System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", name);
                    menuDtos.add(new ExcludeMenuDto(name, Console.readLine()));
                });
        return menuDtos;
    }
}
