package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.Validate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class InputView {
    public List<String> readCoachNames() {
        OutputView.printStartMessage();
        List<String> coachNames = Arrays.stream(Console.readLine().split(",")).collect(Collectors.toList());
        try {
            Validate.validateCoachNames(coachNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            coachNames = readCoachNames();
        }
        return coachNames;
    }
}