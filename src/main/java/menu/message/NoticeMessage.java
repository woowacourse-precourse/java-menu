package menu.message;

import menu.domain.Coach;

public class NoticeMessage {
    public static final String SERVICE_START_NOTICE = "점심 메뉴 추천을 시작합니다.";
    public static final String COACH_NAME_INPUT_NOTICE = "코치의 이름을 입력해 주세요. (, 로 구분)\n";
    public static final String DISLIKE_FOOD_INPUT_NOTICE = "(이)가 못 먹는 메뉴를 입력해 주세요.\n";
    public static final String SERVICE_END_NOTICE = String.format(
        "메뉴 추천 결과입니다.\n"
                + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n"
                + "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]\n"
                + "[ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]\n"
                + "[ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]\n"
                + "[ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]\n\n"
                + "추천을 완료했습니다."
    );
}
