package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;

public class InputView {
    public static final String INPUT_COACHES = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public List<String> readCoaches() {
        System.out.println(INPUT_COACHES);
        return Arrays.stream(Console.readLine().split(","))
                .collect(Collectors.toList());
    }

    public List<String> readBlackList(Coach coach) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coach.getName());
        return Arrays.stream(Console.readLine().split(","))
                .collect(Collectors.toList());
    }
}
