package menu.view;

import java.util.List;

public class OutputView {

    private static final String PROGRAM_START_INFO_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String MENU_RECOMMEND_RESULT_INFO_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String MENU_RECOMMEND_RESULT_INFO_END_MESSAGE = "추천을 완료했습니다.";

    private static final String TABLE_START_SIGN = "[ ";
    private static final String TABLE_DIVIDE_SIGN = " | ";
    private static final String TABLE_END_SIGN = " ]";

    public void printProgramStartInfo() {
        System.out.println(PROGRAM_START_INFO_MESSAGE);
    }


    private String tableRowBuilder(List<String> tableComponents) {
        StringBuilder rowBuilder = new StringBuilder(TABLE_START_SIGN);
        rowBuilder.append(String.join(TABLE_DIVIDE_SIGN, tableComponents));
        rowBuilder.append(TABLE_END_SIGN);

        return rowBuilder.toString();
    }
}
