package menu;

import camp.nextstep.edu.missionutils.Console;
import coach.Coach;
import coach.Managecoach;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class View {
    public void startGame() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public List<String> inputCoachName() {
        while (true) {
            try {
                System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
                String input = Console.readLine();
                System.out.println();
                List<String> coachNameList = List.of(input.split(","));
                checkCoachName(coachNameList);
                return coachNameList;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                System.out.println();
            }
        }
    }

    private void checkCoachName(List<String> coachNameList) {
        if (coachNameList.size() < 2 || coachNameList.size() > 5)
            throw new IllegalArgumentException("코치는 최소 2명 최대 5명으로 입력해야 합니다.");
        for (String coachName : coachNameList) {
            if (coachName.length() < 2 || coachName.length() > 4)
                throw new IllegalArgumentException("코치의 이름은 2~4글자 사이로 입력해야 합니다.");
        }
        Set<String> setNameList = new HashSet<>(coachNameList);
        if (setNameList.size() != coachNameList.size())
            throw new IllegalArgumentException("동일한 코치를 입력했습니다.");
    }

    public List<String> inputCoachHateFood(String coachName) {
        while (true) {
            try {
                System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
                String input = Console.readLine();
                System.out.println();
                List<String> hateList = List.of(input.split(","));
                checkHateSize(hateList);
                return hateList;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                System.out.println();
            }
        }
    }

    private void checkHateSize(List<String> hateList) {
        if (hateList.size() > 2)
            throw new IllegalArgumentException("먹지 못하는 메뉴는 최대 2개 까지 가능합니다.");
    }

    public void printRecommendResult(Managecoach managecoach, List<Integer> category) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategory(category);
        for (Coach coach : managecoach.getCoachList()) {
            printCoachMenu(coach);
        }
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    public void printCoachMenu(Coach coach) {
        System.out.print("[ " + coach.getName() + " | ");
        for (int day = 0; day < 5; day++) {
            System.out.print(coach.getAteFood().get(day));
            if (day < 4) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
    }


    public void printCategory(List<Integer> category) {
        System.out.print("[ 카테고리 | ");
        for (int day = 0; day < 5; day++) {
            System.out.print(numToStr(category.get(day)));
            if (day < 4) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
    }

    public String numToStr(int category) {
        if (category == 1)
            return "일식";
        if (category == 2)
            return "한식";
        if (category == 3)
            return "중식";
        if (category == 4)
            return "아시안";
        if (category == 5)
            return "양식";
        throw new IllegalArgumentException();
    }
}
