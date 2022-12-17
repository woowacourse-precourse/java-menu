package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.model.Member;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<Member> createMember() {
        return Arrays.stream(Console.readLine().split(","))
                .map(Member::new)
                .collect(Collectors.toList());
    }

    public List<String> createMenu() {
        return Arrays.stream(Console.readLine().split(","))
                .collect(Collectors.toList());
    }
}
