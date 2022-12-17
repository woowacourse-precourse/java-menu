package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.view.util.FormatMaker;
import menu.view.util.TextParser;

public class MenuView {
    public static final String MESSAGE_INFORM_START = "점심 메뉴 추천을 시작합니다.";
    public static final String MESSAGE_INPUT_COACHES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String MESSAGE_INFORM_RESULT = "메뉴 추천 결과입니다.";
    public static final String MESSAGE_INFORM_COMPLETE = "추천을 완료했습니다.";

    public static final String FORMAT_INPUT_DISLIKE_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요." + System.lineSeparator();
    public static final String FORMAT_INFORM_ERROR = "[ERROR] %s" + System.lineSeparator();
//[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]
//            [ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]
//            [ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]
//            [ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]
//            [ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]

    public void printInformStart() {
        System.out.println(MESSAGE_INFORM_START);
    }

    public List<String> inputCoachNames() {
        System.out.println();
        System.out.println(MESSAGE_INPUT_COACHES);
        return TextParser.parseNotEmptyLine(Console.readLine());
    }

    public List<List<String>> inputDisLikeMenus(List<String> coachNames) {
        return coachNames.stream()
                .map(this::inputDisLikeMenu)
                .collect(Collectors.toList());
    }

    private List<String> inputDisLikeMenu(String coachName) {
        System.out.println();
        System.out.printf(FORMAT_INPUT_DISLIKE_MENU, coachName);
        return TextParser.parseCouldEmptyLine(Console.readLine());
    }

    public void printResult(List<String> dailyCategories, Map<String, List<String>> coachMenus) {
        System.out.println();
        System.out.println(MESSAGE_INFORM_RESULT);
        System.out.println(FormatMaker.makeMenuResultsDisplay(dailyCategories, coachMenus));
        System.out.println();
        System.out.println(MESSAGE_INFORM_COMPLETE);
    }

    public void printError(String errorMessage) {
        System.out.printf(FORMAT_INFORM_ERROR, errorMessage);
    }
}
