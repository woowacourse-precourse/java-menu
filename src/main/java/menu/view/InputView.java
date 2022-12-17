package menu.view;

import static menu.ConstantBox.EMPTY_STRING;
import static menu.ConstantBox.INPUT_COACH_MESSAGE;
import static menu.ConstantBox.INPUT_FORBID_MENU_MESSAGE;
import static menu.ConstantBox.MAX_COACH_LENGTH;
import static menu.ConstantBox.MAX_COACH_NUM;
import static menu.ConstantBox.MAX_FORBID_MENU_NUM;
import static menu.ConstantBox.MIN_COACH_LENGTH;
import static menu.ConstantBox.MIN_COACH_NUM;
import static menu.ConstantBox.SEPARATOR_FOR_INPUT;
import static menu.ConstantBox.START_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;
import java.util.List;

public class InputView {
    private String tempCoachName;

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public List<String> inputCoachName() {
        System.out.println(INPUT_COACH_MESSAGE);
        String input = Console.readLine();
        List<String> coaches = validateInputCoachName(input);
        validateNumberOfCoach(coaches);
        return coaches;
    }

    public void setCoachName(String name) {
        tempCoachName = name;
    }


    public List<String> inputForbiddenFoods() {
        System.out.println(tempCoachName + INPUT_FORBID_MENU_MESSAGE);
        String input = Console.readLine();
        List<String> forbiddenFood = validateSeparatorForForbiddenFood(input);
        validateNumberOfForbiddenMenu(forbiddenFood);
        for(String menu : forbiddenFood) {
            validateMenu(menu);
        }
        return forbiddenFood;
    }

    private List<String> validateInputCoachName(String input) {
        if (checkInputSizeMoreThanFive(input)) { // input 크기가 5 이상이면 구분자 확인
            validateSeparator(input);
        }
        if (input.contains(SEPARATOR_FOR_INPUT)) { // input 크기가 5 미만이면서 옳바른 구분자를 가지고 있으면 코치 이름 길이 오류이므로 길이 확인
            validateCoachNameLength(input);
        }
        if (checkInputSizeUnderFive(input)) { // input 크기가 5 미만이면서 이상한 구분자를 사용한 경우 구분자 오류 메세지 출력 위해 구분자 확인
            checkInputContainOnlyKorean(input);
        }
        validateCoachNameLength(input);
        return List.of(input.split(SEPARATOR_FOR_INPUT));
    }

    private boolean checkInputSizeMoreThanFive(String input) {
        return input.length() >= 5;
    }

    private boolean checkInputSizeUnderFive(String input) {
        return input.length() < 5;
    }

    private void checkInputContainOnlyKorean(String input) {
        if (input.matches(".*[^ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 ','로 구분해주세요.");
        }
    }

    private void validateSeparator(String input) {
        if (!input.contains(SEPARATOR_FOR_INPUT)) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 ','로 구분해주세요.");
        }
    }

    private void validateCoachNameLength(String input) {
        List<String> coaches = List.of(input.split(SEPARATOR_FOR_INPUT));
        for (String coach : coaches) {
            if (coach.length() < MIN_COACH_LENGTH || coach.length() > MAX_COACH_LENGTH) {
                throw new IllegalArgumentException("[ERROR] 코치의 이름은 2자 이상, 4자 이하여야 합니다.");
            }
        }
    }

    private List<String> validateSeparatorForForbiddenFood(String input) {
        if (input.matches(".*[^ㄱ-ㅎㅏ-ㅣ가-힣 ,]+.*")) {
            throw new IllegalArgumentException("[Error] 못먹는 음식은 ',' 로 구분해주세요");
        }
        if (input.equals(EMPTY_STRING)) {
            return Collections.emptyList();
        }
        return List.of(input.split(SEPARATOR_FOR_INPUT));
    }

    private void validateNumberOfForbiddenMenu(List<String> input) {
        if (input.size() > MAX_FORBID_MENU_NUM) {
            throw new IllegalArgumentException("[ERROR] 입력한 못먹는 음식이 너무 많습니다. (최대 " + MAX_FORBID_MENU_NUM + "개.)");
        }
    }

    private void validateNumberOfCoach(List<String> input) {
        if (input.size() > MAX_COACH_NUM) {
            throw new IllegalArgumentException("[ERROR] 입력한 코치의 수가 너무 많습니다. (최대 " + MAX_COACH_NUM + "개.)");
        }
        if (input.size() < MIN_COACH_NUM) {
            throw new IllegalArgumentException("[ERROR] 입력한 코치의 수가 너무 적습니다. (최소 " + MIN_COACH_NUM + "개.)");
        }
    }

    private void validateMenu(String menu) {
        List<String> allMenu = AllMenu.getAllMenu();
        if (!allMenu.contains(menu)) {
            throw new IllegalArgumentException("[ERROR] 메뉴 리스트에 없는 메뉴입니다.");
        }
    }
}
