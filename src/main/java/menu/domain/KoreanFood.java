package menu.domain;

public enum KoreanFood {
    GIMBAP("김밥"),
    KIMCHI_STEW("김치찌개"),
    LEAF_WRAPS_AND_RICE("쌈밥"),
    SOYBEAN_PASTE_STEW("된장찌개"),
    BIBIMBAP("비빔밥"),
    NOODLE_SOUP("칼국수"),
    BULGOGI("불고기"),
    TTEOKBOKKI("떡볶이"),
    STIR_FRIED_PORK("제육볶음");
    String name;

    KoreanFood(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
