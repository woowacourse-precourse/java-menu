package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Categories;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NotEatView {
    private static final String NEWLINE = "\n";

    private static final String NOT_EAT_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static List<String> getNotEatValue(String name) {
        try {
            System.out.printf(NOT_EAT_MESSAGE + NEWLINE, name);
            String result = Console.readLine();
            List<String> resultArray = Arrays.stream(result.split(",")).collect(Collectors.toList());
            System.out.println();
            validate(resultArray);
            return resultArray;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + NEWLINE);
            return getNotEatValue(name);
        }
    }

    private static void validate(List<String> foods) {
        if (foods.size() >= 3) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 음식은 최대 2개여야 합니다.");
        }

        if (foods.size() == 1 && foods.get(0).equals("")) {
            return;
        }

        foods.forEach(food -> {
            if (!Categories.findByName(food)) {
                throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴입니다.");
            }
        });
    }
}
