package menu.utils.constants;

public enum OutputMessage {

    RECOMMENDATION_START("점심 메뉴 추천을 시작합니다."),
    RESULT_SHOW_MESSAGE("메뉴 추천 결과입니다."),
    DAYS_MESSAGE("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    CATEGORY_MESSAGE("[ 카테고리"),
    GOODBYE_MESSAGE("\n추천을 완료했습니다."),
    DIVISION_SHAPE(" | "),
    START_SHAPE("[ "),
    END_SHAPE(" ]");

    private final String message;

    OutputMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
