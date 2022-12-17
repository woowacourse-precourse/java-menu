package menu.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private static InputValidation inputValidation = new InputValidation();

    public static List<String> readCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");

        String readLine = Console.readLine();
        List<String> names = Arrays.stream(readLine.split(","))
                .map(name -> name.trim())
                .collect(Collectors.toList());

        inputValidation.validateNames(names);

        return names;
    }

    public static List<String> readHateFoods(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");

        String readLine = Console.readLine();
        List<String> hateFoods = new ArrayList<>();

        if (!readLine.isEmpty()) {
            hateFoods = Arrays.stream(readLine.split(","))
                    .map(food -> food.trim())
                    .collect(Collectors.toList());
            inputValidation.validateHateFoodsSize(hateFoods);
        }

        return hateFoods;
    }
}
