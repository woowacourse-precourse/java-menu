package menu.view;

import java.util.List;
import menu.domain.Result;
import menu.utill.Convertor;

public class OutputView {
    private String START_MENTION = "점심 메뉴 추천을 시작합니다.";
    private String RECOMMEND_RESULT = "\n메뉴 추천 결과입니다.";
    private String DAY = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private String END = "\n추천을 완료했습니다.";

    public void start() {
        System.out.println(START_MENTION);
    }

    public void viewMenus(List<Result> menus, List<String> categories) {
        System.out.println(RECOMMEND_RESULT);
        System.out.println(DAY);
        System.out.println(Convertor.toStringCategories(categories));
        List<String> menuResult = Convertor.toStringMenu(menus);
        menuResult.stream()
                .forEach(string -> System.out.println(string));
        System.out.println(END);
    }
}
