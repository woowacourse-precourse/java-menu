package menu.view;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import static java.text.MessageFormat.*;

public class OutputView {

    private static final String INIT_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String COMPLETE_MESSAGE="\n추천을 완료했습니다.";
    private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String DAY_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY_MESSAGE = "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]";

    public void printInit(){
        System.out.println(INIT_MESSAGE);
    }

    public void printErrorMessage(Exception e){
        System.out.println(e.getMessage());
    }

    public void printResult(List<List<String>> menus){
        System.out.println(RESULT_MESSAGE);
        System.out.println(DAY_MESSAGE);
        System.out.println(CATEGORY_MESSAGE);
        menus.stream()
                .forEach(menu -> System.out.println(format("[ {0} ]", menu.stream().collect(Collectors.joining(" | ")))));
        System.out.println(COMPLETE_MESSAGE);
    }
}
