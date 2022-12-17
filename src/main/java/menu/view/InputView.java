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
    public static List<String> readCoachNames() {
        List<String> coachNames = Arrays.stream(Console.readLine().split(",")).collect(Collectors.toList());
        Validate.validateCoachNames(coachNames);
        return coachNames;
    }

    public static List<String> readHateMenus() {
        List<String> hateMenus = Arrays.stream(Console.readLine().split(",")).collect(Collectors.toList());
        if(!hateMenus.get(0).isEmpty()) {
            Validate.validateHateMenu(hateMenus);
        }
        return hateMenus;
    }
}