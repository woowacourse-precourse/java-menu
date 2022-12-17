package menu.output;

import menu.coach.Coach;

import java.util.List;

public class OutputView {
    private static final String startMessage = "점심 메뉴 추천을 시작합니다.\n";
    private static final String inputCoachMessage = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String inputMenuMessage = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String resultStartMessage = "메뉴 추천 결과입니다.";
    private static final String endMessage = "추천을 완료했습니다.";
    private static final String categoryMessage = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";

    public static void printStart() {
        System.out.println(startMessage);
    }

    public static void printCoachMessage() {
        System.out.println(inputCoachMessage);
    }

    public static void printMenuMessage(String coachName) {
        String message = "\n" + coachName + inputMenuMessage;
        System.out.println(message);
    }

    public static void printResult(List<String> category, List<Coach> coaches) {
        System.out.println(resultStartMessage);
        System.out.println(categoryMessage);
        printCategory(category);
        printAllCoachsEatenMenu(coaches);
        System.out.println(endMessage);
    }
    
    private static void printCategory(List<String> category) {
        String message = "[ 카테고리 | " + String.join(" | ", category) + " ]";
        System.out.println(message);
    }

    private static void printAllCoachsEatenMenu(List<Coach> coaches) {
        for (Coach coach: coaches) {
            printOneCoachEatenMenu(coach);
        }
        System.out.println();
    }

    private static void printOneCoachEatenMenu(Coach coach) {
        List<String> foodsEaten = coach.getFoodEaten();
        String coachName = coach.getName();
        String message = "[ " + coachName + " | " + String.join(" | ", foodsEaten) + " ]";
        System.out.println(message);
    }
}
