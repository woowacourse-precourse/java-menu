package menu.view;

import menu.constant.MenuConstants;

import java.util.List;

public class ViewConstants {
    public static final String STARTING_RECOMMENDATION = "점심 메뉴 추천을 시작합니다.";
    public static final String ASKING_NAME = String.format("코치의 이름을 입력해 주세요. (%s 로 구분)", MenuConstants.INPUT_DELIMITER);
    public static final String ASKING_INEDIBLE_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    public static final String RESULT = "메뉴 추천 결과입니다.";
    public static final List<String> DAYS = List.of("구분", "월요일", "화요일", "수요일", "목요일", "금요일");
    public static final String CATEGORY = "카테고리";
    public static final String COMPLETION = "추천을 완료했습니다.";

    public static final String FRONT = "[ ";
    public static final String BACK = " ]";
    public static final String DELIMITER = " | ";
}
