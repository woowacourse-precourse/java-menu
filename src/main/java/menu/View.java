package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class View {

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public String requestInputCoachName() {
        System.out.println("코치의 이름을 입력해주세요. (,로 구분)");
        String input = receiveInput();
        validateCoaches(input);

        return input;
    }

    public String requestUnwantedMenu(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String input = receiveInput();
        validateMenus(input);
        return receiveInput();
    }

    private String receiveInput() {
        String str = Console.readLine();
        return str;
    }


    private void validateMenus(String input) {
        List<String> menus = Arrays.asList(input.split(","));

        if (menus.size() > 2)
            throw new IllegalArgumentException("못먹는 메뉴는 최대 2개까지 입니다.");
    }

    private void validateCoaches(String input) {
        List<String> coaches = Arrays.asList(input.split(","));

        if (coaches.size() < 2 || coaches.size() > 5)
            throw new IllegalArgumentException("코치는 2명 이상, 5명 이하여야 합니다.");

        for (int i = 0; i < coaches.size(); i++) {
            String name = coaches.get(i);
            if (name.length() < 2 || name.length() > 4)
                throw new IllegalArgumentException("코치의 이름은 2~4글자여야 합니다.");
        }
    }
}
