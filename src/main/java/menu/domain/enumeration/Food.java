package menu.domain.enumeration;

public enum Food {
    KYUDONG("일식", "규동"),
    WOODONG("일식", "우동"),
    MISOSIROO("일식","미소시루"),
    SHUSHI("일식","스시"),
    KACHEDONG("일식","가츠동"),
    ONIGIRI("일식","오니기리"),
    HIRICE("일식","하이라이스"),
    RAMEN("일식","라멘"),
    OKONOMI("일식","오코노미야끼"),

    KIMBAB("한식","김밥"),
    KIMCHI_STEW("한식","김치찌개"),
    SAMBAB("한식","쌈밥"),
    BEAN_STEW("한식","된장찌개"),
    BIBIMBAB("한식","비빔밥"),
    KALNOODLE("한식","칼국수"),
    BULLMEET("한식","불고기"),
    TUKBOKKI("한식","떡볶이"),
    JEYUKPORK("한식","제육볶음"),

    FRIEDCHICKEN("중식", "깐풍기"),
    FRIEDNOODLE("중식","볶음면"),
    DONGPAMEET("중식","동파육"),
    JAJANGNOODLE("중식","짜장면"),
    JJANGBBONG("중식","짬뽕"),
    MAPATOFU("중식","마파두부"),
    FRIEDPORK("중식","탕수육"),
    FRIEDTOMATO("중식","토마토 달걀볶음"),
    PEPPERJAPCHAE("중식","고추잡채"),

    PADTHAI("아시안","팟타이"),
    KAOPOD("아시안","카오 팟"),
    NASHIGOLANG("아시안","나시고렝"),
    PINEAPPLERICE("아시안","파인애플 볶음밥"),
    RICENOODLE("아시안","쌀국수"),
    TOMYUMGOONG("아시안","똠얌꿍"),
    BANMI("아시안","반미"),
    WALLNAM("아시안","월남쌈"),
    BUNJJA("아시안","분짜"),

    LASAGNA("양식","라자냐"),
    GRATIN("양식","그라탱"),
    NYOKKI("양식","뇨끼"),
    KKISWO("양식","끼슈"),
    FRENCHTOAST("양식","프렌치 토스트"),
    BARKET("양식","바게트"),
    SPAGHETTI("양식","스파게티"),
    PIZZA("양식","피자"),
    PHANINI("양식","파니니");

    private final String foodName;
    private final String category;

    Food(String category, String foodName) {
        this.foodName = foodName;
        this.category = category;
    }

    public String getFoodName() {
        return this.foodName;
    }

    public String getCategory() {
        return this.category;
    }

    public static Food[] getAllFood() {
        return Food.values();
    }
}
