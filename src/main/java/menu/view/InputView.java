package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static menu.message.InputMsg.*;

public class InputView {

    private final InputValidator inputValidator = new InputValidator();

    public List<String> readCoachesName() {
        System.out.println(INPUT_MSG_COACHES_NAME.get());
        List<String> coachesName = inputValidator.toStrList(Console.readLine());
        // TODO: 검증하기

        return coachesName;
    }

    public List<String> readHateFoods() {
        System.out.println(INPUT_MSG_HATE_FOODS.get());
        List<String> hateFoods = inputValidator.toStrList(Console.readLine());
        // TODO: 검증하기

        return hateFoods;
    }
}
