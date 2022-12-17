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
        System.out.println(tempCoachName+"(이)가 못 먹는 메뉴를 입력해 주세요.");
        String input = Console.readLine();
        List<String> forbiddenFood = validateSeparatorForForbiddenFood(input);
        return forbiddenFood;
    }

    private List<String> validateInputCoachName(String input) {
        if (checkInputSizeOverFive(input)) {
            if (!validateSeparator(input)) {
                throw new IllegalArgumentException("[ERROR] 코치 이름은 ','로 구분해주세요.");
            }
        }
        if (checkInputContainOnlyKorean(input)) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 ','로 구분해주세요.");
        }
        List<String> coaches = List.of(input.split(","));
        validateCoachNameLength(coaches);
        return coaches;
    }

    private boolean checkInputSizeOverFive(String input) {
        return input.length() >= 5;
    }

    private boolean checkInputContainOnlyKorean(String input) {
        return input.matches(".*[^ㄱ-ㅎㅏ-ㅣ가-힣]+.*");
    }

    private boolean validateSeparator(String input) {
        return input.contains(",");
    }

    private void validateCoachNameLength(List<String> coaches) {
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
