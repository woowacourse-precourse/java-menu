package menu;

public enum Category {
    JAPANESE("일식", Menu.JAPANESE),
    KOREAN("한식", Menu.KOREAN),
    CHINESE("중식", Menu.CHINESE),
    ASIAN("아시안", Menu.ASIAN),
    WESTERN("양식", Menu.WESTERN);

    private final String name;
    private final Menu menu;

    Category(String name, Menu menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public Menu getMenu(){
        return menu;
    }
}
