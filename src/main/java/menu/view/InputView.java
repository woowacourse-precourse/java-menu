package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;
import java.util.List;

public class InputView {
    private String tempCoachName;

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public List<String> inputCoachName() {

        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        List<String> coaches = validateInputCoachName(input);
        return coaches;
    }

    public void setCoachName(String name) {
        tempCoachName = name;
    }


    public List<String> inputForbiddenFoods() {
        System.out.println(tempCoachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String input = Console.readLine();
        List<String> forbiddenFood = validateSeparatorForForbiddenFood(input);
        return forbiddenFood;
    }

    private List<String> validateInputCoachName(String input) {
        if (checkInputSizeMoreThanFive(input)) { // input 크기가 5 이상이면 구분자 확인
            validateSeparator(input);
        }
        if (input.contains(",")) { // input 크기가 5 미만이면서 옳바른 구분자를 가지고 있으면 코치 이름 길이 오류이므로 길이 확인
            validateCoachNameLength(input);
        }
        if (checkInputSizeUnderFive(input)) { // input 크기가 5 미만이면서 이상한 구분자를 사용한 경우 구분자 오류 메세지 출력 위해 구분자 확인
            checkInputContainOnlyKorean(input);
        }
        validateCoachNameLength(input);
        return List.of(input.split(","));
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
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 ','로 구분해주세요.");
        }
    }

    private void validateCoachNameLength(String input) {
        List<String> coaches = List.of(input.split(","));
        for (String coach : coaches) {
            if (coach.length() < 2 || coach.length() > 4) {
                throw new IllegalArgumentException("[ERROR] 코치의 이름은 2자 이상, 4자 이하여야 합니다.");
            }
        }
    }

    private List<String> validateSeparatorForForbiddenFood(String input) {
        if (input.matches(".*[^ㄱ-ㅎㅏ-ㅣ가-힣 ,]+.*")) {
            throw new IllegalArgumentException("[Error] 못먹는 음식은 ',' 로 구분해주세요");
        }
        if (input.equals("")) {
            return Collections.emptyList();
        }
        return List.of(input.split(","));
    }
}
