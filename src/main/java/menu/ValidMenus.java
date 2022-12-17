package menu;

import menu.validator.ErrorMessages;

public enum ValidMenus {
    //JAPANESE
    규동("규동"),
    우동("우동"),
    미소시루("미소시루"),
    스시("스시"),
    가츠동("가츠동"),
    오니기리("오니기리"),
    하이라이스("하이라이스"),
    라멘("라멘"),
    오코노미야끼("오코노미야끼"),
    //KOREAN
    김밥("김밥"),
    김치찌개("김치찌개"),
    쌈밥("쌈밥"),
    된장찌개("된장찌개"),
    비빔밥("비빔밥"),
    칼국수("칼국수"),
    불고기("불고기"),
    떡볶이("떡볶이"),
    제육볶음("제육볶음"),
    //CHINESE
    깐풍기("깐풍기"),
    볶음면("볶음면"),
    동파육("동파육"),
    짜장면("짜장면"),
    짬뽕("짬뽕"),
    마파두부("마파두부"),
    탕수육("탕수육"),
    토마토_달걀볶음("토마토 달걀볶음"),
    고추잡채("고추잡채"),
    //ASIA
    팟타이("팟타이"),
    카오_팟("카오 팟"),
    나시고렝("나시고렝"),
    파인애플_볶음밥("파인애플 볶음밥"),
    쌀국수("쌀국수"),
    똠얌꿍("똠얌꿍"),
    반미("반미"),
    월남쌈("월남쌈"),
    분짜("분짜"),
    //WESTERN
    라자냐("라자냐"),
    그라탱("그라탱"),
    뇨끼("뇨끼"),
    끼슈("끼슈"),
    프렌치토스트("프렌치 토스트"),
    바게트("바게트"),
    스파게티("스파게티"),
    피자("스파게티"),
    파니니("파니니");

    private final String name;

    ValidMenus(String name) {
        this.name = name;
    }

    public static ValidMenus findMenuByName(String menuName) {
        for (ValidMenus validMenu : values()) {
            if (validMenu.name.equals(menuName)) {
                return validMenu;
            }
        }
        throw new IllegalArgumentException(ErrorMessages.ERROR.toString() + ErrorMessages.INVALID_MENU);
    }

    public String getName() {
        return name;
    }
}
