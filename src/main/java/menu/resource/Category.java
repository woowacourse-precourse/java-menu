package menu.resource;

public enum Category {
    JAPAN("일식"),
    KOREA("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    FOREIGN("양식");

    private String name;

    public String getName() {
        return name;
    }

    Category(String name){
        this.name = name;
    }
}
