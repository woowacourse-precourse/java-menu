package menu.global;

import static menu.global.GlobalUnitMessage.ENTER;

public enum GlobalMessage {
    ANNOUNCE_START_LUNCH_MENU_RECOMMEND("점심 메뉴 추천을 시작합니다." + ENTER.getMessage()),
    ANNOUNCE_COACHES_NAMES("코치의 이름을 입력해 주세요. (, 로 구분)" + ENTER.getMessage()),
    ANNOUNCE_INPUT_COACH_HATE_FOOD("{0}(이)가 못 먹는 메뉴를 입력해 주세요."),
    ANNOUNCE_LUNCH_MENU_RECOMMEND_RESULT("메뉴 추천 결과입니다." + ENTER.getMessage()),
    ANNOUNCE_DAY("[ 구분 | {0} | {1} | {2} | {3} | {4} ]"),
    ANNOUNCE_CATEGORY("[ 카테고리 | {0} | {1} | {2} | {3} | {4} ]"),
    ANNOUNCE_COACH("[ {0} | {1} | {2} | {3} | {4} | {5} ]"),
    ANNOUNCE_LUNCH_MENU_RECOMMEND_EXIT("추천을 완료했습니다." + ENTER.getMessage());

    private final String message;

    GlobalMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    }
