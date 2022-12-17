package menu.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> readCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        List<String> coachNames = Arrays.asList(
                Console.readLine().split(",")
        );
        addEmptyLine();
        checkSpace(coachNames);
        return coachNames;
    }

    public List<String> readInedibleFoodsOfCoach(String coachName) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coachName);
        addEmptyLine();
        List<String> inedibleFoods = Arrays.asList(
                Console.readLine().split(",")
        );
        addEmptyLine();
        checkSpace(inedibleFoods);
        return inedibleFoods;
    }

    private void addEmptyLine() {
        System.out.println();
    }

    private void checkSpace(List<String> checkTargets) {
        for (String checkTarget : checkTargets) {
            if (checkTarget.contains(" ")) {
                throw new IllegalArgumentException("[ERROR] 입력에 공백을 제거해주세요");
            }
        }
    }
}
