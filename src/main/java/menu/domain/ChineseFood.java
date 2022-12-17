package menu.domain;

public enum ChineseFood {
    DEEP_FRIED_CHICKEN_IN_HOT_PEPPER_SAUCE("깐풍기"),
    FRIED_NOODLES("볶음면"),
    FRIED_PORK_BELLY_IN_SOY_SAUCE("동파육"),
    JAJANGMYEON("짜장면"),
    JJAMPPONG("짬뽕"),
    MAPA_TOFU("마파두부"),
    SWEET_AND_SOUR_PORK("탕수육"),
    FRIED_TOMATOES_AND_EGGS("토마토 달걀볶음"),
    STIR_FRIED_MEAT_AND_VEGETABLES("고추잡채");
    String name;

    ChineseFood(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
