package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class InputView {
    public List<String> scanCoachNames() {
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        List<String> names;
        try {
            names = Arrays.asList(Console.readLine().split(","));
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("[ERROR]코치의 이름은 ,로 구분하여 2명이상 5명 이하 입니다.");
        }
        return validateNames(names);
    }

    public List<String> validateNames(List<String> names) {
        if (names.size() < 2 || 5 < names.size()) {
            throw new IllegalArgumentException("[ERROR] 코치 인원수가 너무 적거나 많음");
        }

        for (String name : names) {
            if (name.length() < 2 || 4 < name.length()) {
                throw new IllegalArgumentException("[ERROR] 코치의 이름 길이는 2이상 4이하 입니다.");
            }
        }
        return names;
    }

    public List<String> scanHatesFood(String name) {
        System.out.println();
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", name);
        List<String> hates;
        try {
            hates = Arrays.asList(Console.readLine().split(","));
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]싫어하는 음식을 잘못 입력 하셨습니다.");
        }
        return validateHatesFood(hates);
    }

    public List<String> validateHatesFood(List<String> hates) {

        if (2 < hates.size()) {
            throw new IllegalArgumentException("[ERROR] 싫어 하는 음식을 너무 많이 입력 하셨습니다.");
        }
        //싫어 하는게 없는 경우
        if (hates.equals(List.of(""))) {
            return new ArrayList<>();
        }
        return hates;
    }
}
