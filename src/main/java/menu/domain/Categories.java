package menu.domain;

import java.util.List;
import menu.utils.CSVUtils;

public enum Categories {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final int categoryCode;
    private final String categoryName;
    private List<String> menu;

    Categories(int categoryCode, String categoryName){
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        initMenu(categoryName);
    }

    private void initMenu(String categoryName){
        this.menu = CSVUtils.getCsvLine(this.categoryName);
    }
}
