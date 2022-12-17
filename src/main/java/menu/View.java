package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class View {
    public void startGame() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public List<String> inputCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        System.out.println(input);
        List<String> coachNameList = List.of(input.split(","));
        checkCoachName(coachNameList);
        return coachNameList;
    }

    private void checkCoachName(List<String> coachNameList) {
        if (coachNameList.size() < 2 || coachNameList.size() > 5)
            throw new IllegalArgumentException("코치는 최소 2명 최대 5명으로 입력해야 합니다.");
        for (String coachName : coachNameList) {
            if (coachName.length() < 2 || coachName.length() > 4)
                throw new IllegalArgumentException("코치의 이름은 2~4글자 사이로 입력해야 합니다.");
        }
    }


}
