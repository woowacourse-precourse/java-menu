package menu.domain;

public enum WesternFood {
    LASAGNA("라자냐"),
    GRATIN("그라탱"),
    GNOCCHI("뇨끼"),
    QUICHE("끼슈"),
    FRENCH_TOAST("프렌치 토스트"),
    BAGUETTE("바게트"),
    SPAGHETTI("스파게티"),
    PIZZA("피자"),
    PANINI("파니니");

    String name;

    WesternFood(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
