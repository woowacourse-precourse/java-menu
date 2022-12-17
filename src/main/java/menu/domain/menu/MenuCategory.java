package menu.domain.menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public enum MenuCategory {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    FRENCH("양식", 5);

    private final String koreanWord;
    private final int categoryCode;

    MenuCategory(String koreanWord, int categoryCode) {
        this.koreanWord = koreanWord;
        this.categoryCode = categoryCode;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getKoreanWord() {
        return koreanWord;
    }

    public static MenuCategory pickRandomMenuCategory() {
        int maxCode = getMaxCode();
        int minCode = getMinCode();
        int pickNumberInRange = Randoms.pickNumberInRange(minCode, maxCode);

        return Arrays.stream(MenuCategory.values())
                .filter(m -> m.categoryCode == pickNumberInRange)
                .findFirst()
                .orElseThrow();
    }

    private static int getMinCode() {
        return Arrays.stream(MenuCategory.values())
                .mapToInt(MenuCategory::getCategoryCode)
                .min()
                .getAsInt();
    }

    private static int getMaxCode() {
        return Arrays.stream(MenuCategory.values())
                .mapToInt(MenuCategory::getCategoryCode)
                .max()
                .getAsInt();
    }
}

