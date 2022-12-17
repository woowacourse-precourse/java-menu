package menu.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public List<String> getCoachesName() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String coachesNameStr = Console.readLine();
        String[] coachesNameArr = coachesNameStr.split(",");
        List<String> coachesName = new ArrayList<>();
        for (int i = 0; i < coachesNameArr.length; i++) {
            coachesName.add(coachesNameArr[i]);
        }
        new Validation().validateCoachesName(coachesName);
        return coachesName;
    }

    public List<String> getHateFood(String coachName) {
        System.out.println("\n" + coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String hateFoodStr = Console.readLine();
        String[] hateFoodArr = hateFoodStr.split(",");
        List<String> hateFood = new ArrayList<>();
        for (int i = 0; i < hateFoodArr.length; i++) {
            hateFood.add(hateFoodArr[i]);
        }
        new Validation().validateHateFood(hateFood);
        return hateFood;
    }
}
