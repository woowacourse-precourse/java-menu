package menu.constant;

import menu.util.EnumUtil;

public enum InputMessage implements EnumUtil {
    START_RECOMMEND("점심 메뉴 추천을 시작합니다.\n")
    , GET_COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)")
    , GET_NOT_EAT_MENU("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.")
    , RECOMMEND_RESULT("\n메뉴 추천 결과입니다.")
    , STOP_RECOMMEND("\n추천을 완료했습니다.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return message;
    }
}
