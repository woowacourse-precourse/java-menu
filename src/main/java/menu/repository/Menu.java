package menu.repository;

import menu.domain.menu.*;

public class Menu {
    public static JapaneseMenu japaneseMenu = new JapaneseMenu();
    public static KoreanMenu koreanMenu = new KoreanMenu();
    public static ChineseMenu chineseMenu = new ChineseMenu();
    public static AsianMenu asianMenu = new AsianMenu();
    public static ItalianMenu italianMenu = new ItalianMenu();

    public static int getCategoryNum(String foodName) {
        if(japaneseMenu.isContain(foodName)) {
            return japaneseMenu.foodCategory.getCategoryNumber();
        } else if (koreanMenu.isContain(foodName)) {
            return koreanMenu.foodCategory.getCategoryNumber();
        } else if (chineseMenu.isContain(foodName)) {
            return chineseMenu.foodCategory.getCategoryNumber();
        } else if (asianMenu.isContain(foodName)) {
            return asianMenu.foodCategory.getCategoryNumber();
        } else if (italianMenu.isContain(foodName)) {
            return italianMenu.foodCategory.getCategoryNumber();
        }
        return -1;
    }
}
