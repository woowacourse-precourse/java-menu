package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> scanCoachNames() {
        try {
            System.out.println();
            System.out.println("코치의 이름을 입력해 주세요(, 로 구분)");
            List<String> names = Arrays.asList(Console.readLine().split(","));
            return validateNames(names);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]코치의 이름은 ,로 구분하여 2명이상 5명 이하 입니다.");
        }
    }

    private List<String> validateNames(List<String> names) {
        if (names.size() < 2 || 5 < names.size()) {
            throw new IllegalArgumentException("[ERROR] 코치 인원수가 너무 적거나 많음");
        }
        //TODO : 이름 글자수 확인 해야함
        return names;
    }

    public List<String> scanHatesFood(String name) {
        try {
            System.out.println();
            System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n",name);
            List<String> hates = Arrays.asList(Console.readLine().split(","));
            return validateHatesFood(hates);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]싫어하는 음식을 잘못 입력 하셨습니다.");
        }


    }

    private List<String> validateHatesFood(List<String> hates) {
        if (2 < hates.size()) {
            throw new IllegalArgumentException("[ERROR] 싫어 하는 음식을 너무 많이 입력 하셨습니다.");
        }
        return hates;
    }
}
