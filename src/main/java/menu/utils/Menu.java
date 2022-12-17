package menu.utils;

import java.util.Arrays;

public enum Menu {
    GYUDONG("규동", "일식", 1 , 1),
    UDONG("우동", "일식",2, 1),
    MISO("미소시루", "일식",3, 1),
    SUSI("스시", "일식",4, 1),
    GATCHDONG("가츠동", "일식",5, 1),
    ONIGIRI("오니기리", "일식",6, 1),
    HIRICE("하이라이스", "일식",7, 1),
    RAMEN("라멘", "일식",8, 1),
    OCONOMIYAKI("오코노미야끼", "일식",9, 1),
    KIMBAB("김밥", "한식",1, 2),
    KIMCHI("김치찌개", "한식",2, 2),
    SSAMBAB("쌈밥", "한식",3, 2),
    DOWNJANG("된장찌개", "한식",4, 2),
    BIBIMBAP("비빔밥", "한식",5, 2),
    KALGUKSU("칼국수", "한식",6, 2),
    BULGOGI("불고기", "한식",7, 2),
    DDUCKBOKI("떡볶이", "한식",8, 2),
    JAEYUK("제육볶음", "한식",9, 2),
    KKANPUNGGI("깐풍기", "중식",1, 3),
    BOKUMMEYON("볶음면", "중식",2, 3),
    DONGPAYUK("동파육", "중식",3, 3),
    JAJANGMYEON("짜장면", "중식",4, 3),
    JJAMPONG("짬뽕", "중식",5, 3),
    MAFATOFU("마파두부", "중식",6, 3),
    TANGSUYUK("탕수육", "중식",7, 3),
    TOMATO("토마토 달걀볶음", "중식",8, 3),
    GOCHUJAMCHAE("고추잡채", "중식",9, 3),
    PATAI("팟타이", "아시안",1, 4),
    CAOPAT("카오 팟", "아시안",2, 4),
    NASIGORANG("나시고랭", "아시안",3, 4),
    PINEAPPLE("파인애플 볶음밥", "아시안",4, 4),
    SSALGUKSU("쌀국수", "아시안",5, 4),
    DDOMYANGGUNG("똠양꿍", "아시안",6, 4),
    BANMI("반미", "아시안",7, 4),
    WOLNAMSSAM("월남쌈", "아시안",8, 4),
    BBUNJJA("분짜", "아시안",9, 4),
    RAJANYA("라자냐", "양식",1, 5),
    GRATANG("그라탱", "양식",2, 5),
    NYOKI("뇨끼", "양식",3, 5),
    KISSU("끼슈", "양식",4, 5),
    FRANCHTOAST("프렌치 토스트", "양식",5, 5),
    BAGGET("바게트", "양식",6, 5),
    SPAGGETI("스파게티", "양식",7, 5),
    PIZZA("피자", "양식",8, 5),
    PANINI("파니니", "양식",9, 5),
    ;

    private final String menu;
    private final String category;
    private final int pickNumber;
    private final int categoryNumber;

    Menu(String menu, String category, int pickNumber, int categoryNumber) {
        this.menu = menu;
        this.category = category;
        this.pickNumber = pickNumber;
        this.categoryNumber = categoryNumber;
    }

    public String getMenu() {
        return menu;
    }

    public String getCategory() {
        return category;
    }

    public int getPickNumber() {
        return pickNumber;
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }

    public static Menu valueOfMenu(String menu) {
        return Arrays.stream(values())
                .filter(value -> value.menu.equals(menu))
                .findAny()
                .orElse(null);
    }
}
