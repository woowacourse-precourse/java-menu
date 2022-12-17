package menu.view;

import java.util.Scanner;
import menu.DTO.CoachNameDTO;
import menu.DTO.FoodCanNotEatDTO;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final CoachNameDTO coachNameDTO = CoachNameDTO.getInstnace();
    private static final String COACH_NAME_INPUT_REQUEST
            = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String FOOD_CAN_NOT_EAT_INPUT_REQUEST
            = "(이)가 못 먹는 메뉴를 입력해 주세요.";


    public static CoachNameDTO readCoachName() {
        System.out.println();
        printCoachNameInputRequest();
        coachNameDTO.setCoaches(Console.readLine());
        return coachNameDTO;
    }

    public static FoodCanNotEatDTO readFoodCanNotEat(String name) {
        System.out.println();
        printFoodCanNotEatInputRequest(name);
        return new FoodCanNotEatDTO(scanner.nextLine());
    }

    private static void printCoachNameInputRequest() {
        System.out.println(COACH_NAME_INPUT_REQUEST);
    }

    private static void printFoodCanNotEatInputRequest(String name) {
        System.out.println(name + FOOD_CAN_NOT_EAT_INPUT_REQUEST);
    }


}
