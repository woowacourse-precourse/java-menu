package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.PrintMsg;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public String getUserInput() {
        return Console.readLine();
    }

    /**
     * 코치 이름 입력 함수
     * @return
     */
    public List<String> readCoachNames() {
        String userInput = getUserInput();
        return checkAndGetCoachNames(userInput);
    }
    public List<String> checkAndGetCoachNames(String userInput) {
        InputException.nullException(userInput);
        InputException.notEndFormatException(userInput);

        List<String> userList = List.of(userInput.split(PrintMsg.COMMA.getMsg()));
        InputException.notMemberSizeException(userList.size());
        InputException.notCoachFormatException(userList);
        return userList;
    }

    /**
     * 코치 당 못 먹는 메뉴 입력 함수
     * @return
     */
    public List<String> readNotEatFoods() {
        String userInput = getUserInput();
        return checkAndGetFoods(userInput);
    }
    public List<String> checkAndGetFoods(String userInput) {
        InputException.notEndFormatException(userInput);
        List<String> foods = List.of(userInput.split(PrintMsg.COMMA.getMsg()));
        InputException.notFoodsSizeException(foods.size());
        return foods;
    }
}
