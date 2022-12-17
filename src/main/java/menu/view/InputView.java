package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.util.Converter;
import menu.view.dto.NotEatFoodsDTO;

public class InputView {

    private static final String INPUT_COACH = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_NOT_EAT_FOODS = "%s(이)가 못 먹는 메뉴를 입력해 주세요. \n ";

    public static List<String> readCoach() {
        System.out.println(INPUT_COACH);
        String coaches = Console.readLine();
        // 검증
        return Converter.restArrayToList(coaches);
    }

    public static NotEatFoodsDTO readNotEatFoodByCoach(String name) {
        System.out.printf(INPUT_NOT_EAT_FOODS , name);
        String notEatFoods = Console.readLine();
        // 검증
        return new NotEatFoodsDTO(name, Converter.restArrayToList(notEatFoods));
    }


}
