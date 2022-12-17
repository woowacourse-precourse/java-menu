package menu.model;

import menu.util.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {

    JAPAN_ONE("규동"),
    JAPAN_TWO("우동"),
    JAPAN_THREE("미소시루"),
    JAPAN_FOUR("스시"),
    JAPAN_FIVE("가츠동"),
    JAPAN_SIX("오니기리"),
    JAPAN_SEVEN("하이라이스"),
    JAPAN_EIGHT("라멘"),
    JAPAN_NINE("오코노미야끼"),

    KOREA_ONE("김밥"),
    KOREA_TWO("김치찌개"),
    KOREA_THREE("쌈밥"),
    KOREA_FOUR("된장찌개"),
    KOREA_FIVE("비빔밥"),
    KOREA_SIX("칼국수"),
    KOREA_SEVEN("불고기"),
    KOREA_EIGHT("떡볶이"),
    KOREA_NINE("제육볶음"),

    CHINA_ONE("깐풍기"),
    CHINA_TWO("볶음면"),
    CHINA_THREE("동파육"),
    CHINA_FOUR("짜장면"),
    CHINA_FIVE("짬뽕"),
    CHINA_SIX("마파두부"),
    CHINA_SEVEN("탕수육"),
    CHINA_EIGHT("토마토 달걀볶음"),
    CHINA_NINE("고추잡채"),

    ASIA_ONE("팟타이"),
    ASIA_TWO("카오 팟"),
    ASIA_THREE("나시고렝"),
    ASIA_FOUR("파인애플 볶음밥"),
    ASIA_FIVE("쌀국수"),
    ASIA_SIX("똠얌꿍"),
    ASIA_SEVEN("반미"),
    ASIA_EIGHT("월남쌈"),
    ASIA_NINE("분짜"),

    WESTERN_ONE("라자냐"),
    WESTERN_TWO("그라탱"),
    WESTERN_THREE("뇨끼"),
    WESTERN_FOUR("끼슈"),
    WESTERN_FIVE("프렌치 토스트"),
    WESTERN_SIX("바게트"),
    WESTERN_SEVEN("스파게티"),
    WESTERN_EIGHT("피자"),
    WESTERN_NINE("파니니"),

    EMPTY(" ");

    private String name;

    Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<Menu> makeMenus(String menus){
        List<String> parsedMenu = parseMenu(menus);
        validateMenu(parsedMenu);
        return parsedMenu.stream().map(m -> from(m)).collect(Collectors.toList());
    }

    public static List<String> parseMenu(String menus){
        String[] split = menus.split(",");
        return Arrays.stream(split).distinct().collect(Collectors.toList());
    }

    public static void validateMenu(List<String> parsedMenu){
        validateFormat(parsedMenu);
        validateSize(parsedMenu);

    }

    private static void validateFormat(List<String> parsedMenu) {
        if(isPresentBlank(parsedMenu) && parsedMenu.size()>=2){
            throw new IllegalArgumentException(ErrorMessage.MENU_FORMAT_ERROR_MESSAGE.getMessage());
        }
    }

    private static boolean isPresentBlank(List<String> parsedMenu){
        return parsedMenu.stream().anyMatch(menu -> menu.isBlank());
    }

    private static void validateSize(List<String> menus){
        if(isCorrectSize(menus)){
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.MENU_SIZE_ERROR_MESSAGE.getMessage());
    }

    private static boolean isCorrectSize(List<String> menus) {
        return menus.size() >= 0 && menus.size() <= 2;
    }


    public static Menu from(String name){
        return Arrays.stream(Menu.values())
                .filter(m -> m.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NON_FIND_MENU_ERROR_MESSAGE.getMessage()));
    }


}
