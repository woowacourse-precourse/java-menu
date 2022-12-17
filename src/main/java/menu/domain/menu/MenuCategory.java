package menu.domain.menu;

public enum MenuCategory {
    KOREAN("한식"),
    JAPANESE("일식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    FRENCH("양식");

    private final String koreanWord;

    MenuCategory(String koreanWord) {
        this.koreanWord = koreanWord;
    }
}

