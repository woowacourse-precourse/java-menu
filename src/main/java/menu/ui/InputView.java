package menu.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> readCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String coachNamesRaw = Console.readLine();
        checkEndIsComma(coachNamesRaw);
        List<String> coachNames = Arrays.asList(coachNamesRaw.split(","));
        addEmptyLine();
        checkSpace(coachNames);
        System.out.println(coachNames);
        return coachNames;
    }

    private void checkEndIsComma(String coachNamesRaw) {
        if (coachNamesRaw.startsWith(",") || coachNamesRaw.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 시작과 끝에 있는 \",\"는 지워주세요");
        }
    }

    public List<String> readInedibleMenusOfCoach(String coachName) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coachName);
        addEmptyLine();
        List<String> inedibleMenus = Arrays.asList(
                Console.readLine().split(",")
        );
        addEmptyLine();
        checkSpace(inedibleMenus);
        return inedibleMenus;
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
